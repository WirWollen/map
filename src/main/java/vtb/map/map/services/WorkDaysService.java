package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.WorkDaysConverter;
import vtb.map.map.dtos.WorkDaysDto;
import vtb.map.map.repo.WorkDaysRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkDaysService {
    private final WorkDaysRepo workDaysRepo;

    public List<WorkDaysDto> showAllWorkDays(){
        return workDaysRepo.findAll().stream().map(WorkDaysConverter::toDto).collect(Collectors.toList());
    }

    public WorkDaysDto showWorkDaysDto(long id){return WorkDaysConverter.toDto(workDaysRepo.findById(id).get());}

    @Deprecated
    public boolean addWorkDaysList(List<WorkDaysDto> dtoList){
        workDaysRepo.saveAll(dtoList.stream().map(WorkDaysConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    public Long addWorkDay(WorkDaysDto dto) {
        return workDaysRepo.save(WorkDaysConverter.toEntity(dto)).getId();
    }

    @Transactional
    public boolean updateWorkDays(WorkDaysDto dto) {
        if (workDaysRepo.existsById(dto.getId())) {
            workDaysRepo.save(WorkDaysConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteWorkDaysById(long id) {
        workDaysRepo.deleteById(id);
        return true;
    }
}
