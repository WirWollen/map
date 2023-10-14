package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.WorkloadCorporativeConverter;
import vtb.map.map.dtos.WorkloadCorporativeDto;
import vtb.map.map.repo.DepartmentRepo;
import vtb.map.map.repo.WorkloadCorporativeRepo;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkloadCorporativeService {
    private final DepartmentRepo departmentRepo;
    private final WorkloadCorporativeRepo workloadCorporativeRepo;
    private final Random random = new Random();

    public int trialTicketGenerator() {
        return random.nextInt(101);
    }

    public int trialElectronicQueueGenerator() {
        return random.nextInt(11);
    }

    public Map<Long, Integer> getWorkloadCorporative(Long localityId) {
        return departmentRepo.getWorkloadCorporative(localityId).stream().collect(Collectors.toMap(Long::longValue, el -> calculateWorkloadCorporative()));
    }

    public int calculateWorkloadCorporative() {
        return random.nextInt(101);
    }

    public List<WorkloadCorporativeDto> showAllWorkloadCorporative() {
        return workloadCorporativeRepo.findAll().stream().map(WorkloadCorporativeConverter::toDto).collect(Collectors.toList());
    }

    public WorkloadCorporativeDto showWorkloadCorporativeDto(long id) {
        return WorkloadCorporativeConverter.toDto(workloadCorporativeRepo.findById(id).get());
    }

    public boolean addWorkloadCorporativeList(List<WorkloadCorporativeDto> dtoList) {
        workloadCorporativeRepo.saveAll(dtoList.stream().map(WorkloadCorporativeConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateWorkloadCorporative(WorkloadCorporativeDto dto) {
        if (workloadCorporativeRepo.existsById(dto.getId())) {
            workloadCorporativeRepo.save(WorkloadCorporativeConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteWorkloadCorporativeById(long id) {
        workloadCorporativeRepo.deleteById(id);
        return true;
    }
}
