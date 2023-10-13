package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.AvailabilityConverter;
import vtb.map.map.dtos.AvailabilityDto;
import vtb.map.map.repo.AvailabilityRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AvailabilityService {
    private final AvailabilityRepo availabilityRepo;

    public List<AvailabilityDto> showAllAvailability(){
        return availabilityRepo.findAll().stream().map(AvailabilityConverter::toDto).collect(Collectors.toList());
    }

    public AvailabilityDto showAvailabilityDto(long id){return AvailabilityConverter.toDto(availabilityRepo.findById(id).get());}

    public boolean addAvailabilityList(List<AvailabilityDto> dtoList){
        availabilityRepo.saveAll(dtoList.stream().map(AvailabilityConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateAvailability(AvailabilityDto dto) {
        if (availabilityRepo.existsById(dto.getId())) {
            availabilityRepo.save(AvailabilityConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteAvailabilityById(long id) {
        availabilityRepo.deleteById(id);
        return true;
    }
}
