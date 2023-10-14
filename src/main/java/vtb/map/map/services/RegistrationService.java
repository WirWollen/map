package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.RegistrationConverter;
import vtb.map.map.dtos.RegistrationDto;
import vtb.map.map.exceptions.TheSpecifiedDateIsNotPossibleException;
import vtb.map.map.repo.RegistrationRepo;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final RegistrationRepo registrationRepo;

    public List<RegistrationDto> showAllRegistration() {
        return registrationRepo.findAll().stream().map(RegistrationConverter::toDto).collect(Collectors.toList());
    }

    public RegistrationDto showRegistrationDto(long id) {
        return RegistrationConverter.toDto(registrationRepo.findById(id).get());
    }

    //TODO
    private boolean checkAvailabilityDate(Instant time) {
        return true;
    }

    //TODO
    private boolean checkOpeningHours(Instant time) {
        return true;
    }

    //TODO
    private boolean bankExistenceCheck(Long departmentId) {
        return true;
    }

    @Transactional
    public String register(Long departmentId, Instant time) throws TheSpecifiedDateIsNotPossibleException {
        RegistrationDto dto = new RegistrationDto();
        if (bankExistenceCheck(departmentId)) {
            if (!checkOpeningHours(time)) {
                throw new TheSpecifiedDateIsNotPossibleException("Discrepancy with bank opening hours");
            }
            if (checkAvailabilityDate(time)) {
                dto.setDatetime(new Timestamp(time.toEpochMilli()));
            } else {
                throw new TheSpecifiedDateIsNotPossibleException("The specified time is already taken");
            }
            dto.setDepartment_id(departmentId);
            dto.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8));
//            registrationRepo.save(RegistrationConverter.toEntity(dto));
        }
        return dto.getCode();
    }

    @Transactional
    public boolean updateRegistration(RegistrationDto dto) {
        if (registrationRepo.existsById(dto.getId())) {
            registrationRepo.save(RegistrationConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteRegistrationById(long id) {
        registrationRepo.deleteById(id);
        return true;
    }
}
