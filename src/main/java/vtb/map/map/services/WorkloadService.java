package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vtb.map.map.repo.DepartmentRepo;

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
}
