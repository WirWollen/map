package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.RegistrationConverter;
import vtb.map.map.dtos.RegistrationDto;
import vtb.map.map.enums.Individual;
import vtb.map.map.exceptions.TheSpecifiedDateIsNotPossibleException;
import vtb.map.map.repo.RegistrationRepo;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
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
