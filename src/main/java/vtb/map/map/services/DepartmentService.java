package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.DepartmentConverter;
import vtb.map.map.converters.RegistrationConverter;
import vtb.map.map.dtos.DepartmentDto;
import vtb.map.map.dtos.RegistrationDto;
import vtb.map.map.entities.DepartmentEntity;
import vtb.map.map.entities.LocalityEntity;
import vtb.map.map.enums.Individual;
import vtb.map.map.exceptions.TheSpecifiedDateIsNotPossibleException;
import vtb.map.map.repo.DepartmentRepo;
import vtb.map.map.repo.RegistrationRepo;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    @Value("${bank.register-time.min}")
    private Integer registerTime;
    private final DepartmentRepo departmentRepo;
    private final RegistrationRepo registrationRepo;
    private final WorkloadService workloadService;

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

    private boolean checkAvailabilityDate(Long departmentId, Timestamp time) {
        return registrationRepo.checkAvailabilityDate(departmentId, time, plusTime(time));
    }

    private Timestamp plusTime(Timestamp dateTime) {
        return Timestamp.valueOf(dateTime.toLocalDateTime().plus(registerTime, ChronoUnit.MINUTES));
    }

    //TODO воткнуть ограничение времени регистрации
    public boolean typeOfClient(Individual type, Timestamp time) {
        boolean result = false;
        switch (type) {
            case INDIVIDUAL -> result = checkOpeningHoursInd(time);
            //TODO
            case CORPORATE -> {}
        }
        return result;
    }

    private boolean checkOpeningHoursInd(Timestamp time) {
        boolean result = false;
        switch (time.toLocalDateTime().toLocalDate().getDayOfWeek()) {
            case MONDAY -> result = registrationRepo.workingMondayFiz(new Time(time.getTime()), new Time(plusTime(time).getTime()));
            case TUESDAY -> result = registrationRepo.workingTuesdayFiz(new Time(time.getTime()), new Time(plusTime(time).getTime()));
            case WEDNESDAY -> result = registrationRepo.workingWednesdayFiz(new Time(time.getTime()), new Time(plusTime(time).getTime()));
            case THURSDAY -> result = registrationRepo.workingThursdayFiz(new Time(time.getTime()), new Time(plusTime(time).getTime()));
            case FRIDAY -> result = registrationRepo.workingFridayFiz(new Time(time.getTime()), new Time(plusTime(time).getTime()));
            case SATURDAY -> result = registrationRepo.workingSaturdayFiz(new Time(time.getTime()), new Time(plusTime(time).getTime()));
            case SUNDAY -> result = registrationRepo.workingSundayFiz(new Time(time.getTime()), new Time(plusTime(time).getTime()));
        }
        return result;
    }

    private boolean bankExistenceCheck(Long departmentId) {
        return registrationRepo.departmentExists(departmentId);
    }

    @Transactional
    public String register(Individual type, Long departmentId, Timestamp time) throws TheSpecifiedDateIsNotPossibleException {
        RegistrationDto dto = new RegistrationDto();
        if (bankExistenceCheck(departmentId)) {
            boolean result = false;
            switch (type) {
                case INDIVIDUAL -> result = checkOpeningHoursInd(time);
                //TODO add corpo
                case CORPORATE -> {}
            }
            if (!result) {
                throw new TheSpecifiedDateIsNotPossibleException("Discrepancy with bank opening hours");
            }
            if (checkAvailabilityDate(departmentId, time)) {
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
}
