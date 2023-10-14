package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.WorkloadConverter;
import vtb.map.map.dtos.WorkloadDto;
import vtb.map.map.repo.DepartmentRepo;
import vtb.map.map.repo.WorkloadRepo;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * данный сервис создаёт mock-объекты
 */
@Service
@RequiredArgsConstructor
public class WorkloadService {
    private final DepartmentRepo departmentRepo;
    private final WorkloadRepo workloadRepo;
    private final Random random = new Random();

    public int trialTicketGenerator() {
        return random.nextInt(101);
    }

    public int trialElectronicQueueGenerator() {
        return random.nextInt(11);
    }

    public Map<Long, Integer> getWorkload(Long localityId) {
        return departmentRepo.getWorkload(localityId).stream().collect(Collectors.toMap(Long::longValue, el -> calculateWorkload()));
    }

    public int calculateWorkload() {
        return random.nextInt(101);
    }

    public List<WorkloadDto> showAllWorkload() {
        return workloadRepo.findAll().stream().map(WorkloadConverter::toDto).collect(Collectors.toList());
    }

    public WorkloadDto showWorkloadDto(long id) {
        return WorkloadConverter.toDto(workloadRepo.findById(id).get());
    }

    public boolean addWorkloadList(List<WorkloadDto> dtoList) {
        workloadRepo.saveAll(dtoList.stream().map(WorkloadConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateWorkload(WorkloadDto dto) {
        if (workloadRepo.existsById(dto.getId())) {
            workloadRepo.save(WorkloadConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteWorkloadById(long id) {
        workloadRepo.deleteById(id);
        return true;
    }
}
