package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.DayConverter;
import vtb.map.map.dtos.DayDto;
import vtb.map.map.repo.DaysRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DaysService {
    private final DaysRepo daysRepo;

    public List<DayDto> showAllDays(){
        return daysRepo.findAll().stream().map(DayConverter::toDto).collect(Collectors.toList());
    }

    public DayDto showDaysDto(long id){return DayConverter.toDto(daysRepo.findById(id).get());}

    public boolean addDaysList(List<DayDto> dtoList){
        daysRepo.saveAll(dtoList.stream().map(DayConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateDays(DayDto dto) {
        if (daysRepo.existsById(dto.getId())) {
            daysRepo.save(DayConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteDaysById(long id) {
        daysRepo.deleteById(id);
        return true;
    }
}
