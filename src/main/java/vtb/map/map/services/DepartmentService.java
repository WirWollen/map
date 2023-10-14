package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.DepartmentConverter;
import vtb.map.map.converters.RegistrationConverter;
import vtb.map.map.converters.RegistrationCorporativeConverter;
import vtb.map.map.dtos.DepartmentDto;
import vtb.map.map.dtos.RegistrationCorporativeDto;
import vtb.map.map.dtos.RegistrationDto;
import vtb.map.map.enums.Individual;
import vtb.map.map.exceptions.TheSpecifiedDateIsNotPossibleException;
import vtb.map.map.repo.DepartmentRepo;
import vtb.map.map.repo.RegistrationCorporativeRepo;
import vtb.map.map.repo.RegistrationRepo;
import vtb.map.map.repo.WorkloadRepo;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    @Value("${bank.register-time.min}")
    private Integer registerTime;
    @Value("${bank.register-time.del}")
    private Integer del;
    @Value("${bank.overwatch.before-min}")
    private Integer overwatchBefore;
    @Value("${bank.overwatch.after-min}")
    private Integer overwatchAfter;
    private final DepartmentRepo departmentRepo;
    private final RegistrationRepo registrationRepo;
    private RegistrationCorporativeRepo registrationCorporativeRepo;
    private final WorkloadService workloadService;
    private final WorkloadRepo workloadRepo;

    public List<DepartmentDto> showAllDepartments() {
        return departmentRepo.findAll().stream().map(DepartmentConverter::toDto).collect(Collectors.toList());
    }

    public DepartmentDto showDepartmentDto(long id) {
        return DepartmentConverter.toDto(departmentRepo.findById(id).get());
    }

    public boolean addDepartmentList(List<DepartmentDto> dtoList) {
        departmentRepo.saveAll(dtoList.stream().map(DepartmentConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateDepartment(DepartmentDto dto) {
        if (departmentRepo.existsById(dto.getId())) {
           departmentRepo.save(DepartmentConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteDepartmentById(long id) {
        departmentRepo.deleteById(id);
        return true;
    }

    public Map<Long, Integer> getWorkload(Long localityId) {
        return workloadService.getWorkload(localityId);
    }

    private boolean checkAvailabilityDate(Individual type, Long departmentId, Timestamp time) {
        boolean result = false;
        switch (type) {
            case INDIVIDUAL -> result = registrationRepo.checkAvailabilityDate(departmentId, time, plusTime(time));
            case CORPORATE -> result = registrationCorporativeRepo.checkAvailabilityDate(departmentId, time, plusTime(time));
        }
        return result;
    }

    private Timestamp plusTime(Timestamp dateTime) {
        return Timestamp.valueOf(dateTime.toLocalDateTime().plus(registerTime, ChronoUnit.MINUTES));
    }

    //TODO воткнуть ограничение времени регистрации
    public boolean typeOfClient(Individual type, Timestamp time) {
        boolean result = false;
        switch (type) {
            case INDIVIDUAL -> result = checkOpeningHoursInd(time);
            case CORPORATE -> result = checkOpeningHoursCorpo(time);
        }
        return result;
    }

    //TODO воткнуть фабрику
    private boolean checkOpeningHoursInd(Timestamp time) {
        boolean result = false;
        switch (time.toLocalDateTime().toLocalDate().getDayOfWeek()) {
            case MONDAY -> result = registrationRepo.workingMonday(new Time(time.getTime()), new Time(plusTime(time).getTime()));
            case TUESDAY -> result = registrationRepo.workingTuesday(new Time(time.getTime()), new Time(plusTime(time).getTime()));
            case WEDNESDAY -> result = registrationRepo.workingWednesday(new Time(time.getTime()), new Time(plusTime(time).getTime()));
            case THURSDAY -> result = registrationRepo.workingThursday(new Time(time.getTime()), new Time(plusTime(time).getTime()));
            case FRIDAY -> result = registrationRepo.workingFriday(new Time(time.getTime()), new Time(plusTime(time).getTime()));
            case SATURDAY -> result = registrationRepo.workingSaturday(new Time(time.getTime()), new Time(plusTime(time).getTime()));
            case SUNDAY -> result = registrationRepo.workingSunday(new Time(time.getTime()), new Time(plusTime(time).getTime()));
        }
        return result;
    }

    private boolean checkOpeningHoursCorpo(Timestamp time) {
        boolean result = false;
        switch (time.toLocalDateTime().toLocalDate().getDayOfWeek()) {
            case MONDAY -> result = registrationCorporativeRepo.workingMonday(new Time(time.getTime()), new Time(plusTime(time).getTime()));
            case TUESDAY -> result = registrationCorporativeRepo.workingTuesday(new Time(time.getTime()), new Time(plusTime(time).getTime()));
            case WEDNESDAY -> result = registrationCorporativeRepo.workingWednesday(new Time(time.getTime()), new Time(plusTime(time).getTime()));
            case THURSDAY -> result = registrationCorporativeRepo.workingThursday(new Time(time.getTime()), new Time(plusTime(time).getTime()));
            case FRIDAY -> result = registrationCorporativeRepo.workingFriday(new Time(time.getTime()), new Time(plusTime(time).getTime()));
            case SATURDAY -> result = registrationCorporativeRepo.workingSaturday(new Time(time.getTime()), new Time(plusTime(time).getTime()));
            case SUNDAY -> result = registrationCorporativeRepo.workingSunday(new Time(time.getTime()), new Time(plusTime(time).getTime()));
        }
        return result;
    }

    private boolean bankExistenceCheck(Individual type, Long departmentId) {
        boolean result = false;
        switch (type) {
            case INDIVIDUAL -> registrationRepo.departmentExists(departmentId);
            case CORPORATE -> registrationCorporativeRepo.departmentExists(departmentId);
        }
        return result;
    }

    //TODO воткнуть полиморфизм
    private String individual(Individual type, Long departmentId, Timestamp time) throws TheSpecifiedDateIsNotPossibleException {
        RegistrationDto dto = new RegistrationDto();
        if (bankExistenceCheck(type, departmentId)) {
            if (!typeOfClient(type, time)) {
                throw new TheSpecifiedDateIsNotPossibleException("Discrepancy with bank opening hours");
            }
            if (checkAvailabilityDate(type, departmentId, time)) {
                dto.setDatetime(time);
            } else {
                throw new TheSpecifiedDateIsNotPossibleException("The specified time is already taken");
            }
            dto.setDepartment_id(departmentId);
            dto.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8));
            registrationRepo.save(RegistrationConverter.toEntity(dto));
        }
        return dto.getCode();
    }

    private String corpo(Individual type, Long departmentId, Timestamp time) throws TheSpecifiedDateIsNotPossibleException {
        RegistrationCorporativeDto dto = new RegistrationCorporativeDto();
        if (bankExistenceCheck(type, departmentId)) {
            if (!typeOfClient(type, time)) {
                throw new TheSpecifiedDateIsNotPossibleException("Discrepancy with bank opening hours");
            }
            if (checkAvailabilityDate(type, departmentId, time)) {
                dto.setDatetime(time);
            } else {
                throw new TheSpecifiedDateIsNotPossibleException("The specified time is already taken");
            }
            dto.setDepartment_id(departmentId);
            dto.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8));
            registrationCorporativeRepo.save(RegistrationCorporativeConverter.toEntity(dto));
        }
        return dto.getCode();
    }

    @Transactional
    public String register(Individual type, Long departmentId, Timestamp time) throws TheSpecifiedDateIsNotPossibleException {
        String result = null;
        switch (type) {
            case INDIVIDUAL -> result = individual(type, departmentId, time);
            case CORPORATE -> result = corpo(type, departmentId, time);
        }
        return result;
    }

    public Integer calculateTimeInd(Long localityId) {
        Integer countClients = workloadRepo.calculateClients(LocalDateTime.now().minus(overwatchBefore, ChronoUnit.MINUTES), LocalDateTime.now().plus(overwatchAfter, ChronoUnit.MINUTES), localityId);
        Integer countElectro = registrationRepo.calculateRegistration(LocalDateTime.now().minus(overwatchBefore, ChronoUnit.MINUTES), LocalDateTime.now().plus(overwatchAfter, ChronoUnit.MINUTES), localityId);

        return (countClients + countElectro) * registerTime / del;
    }
}
