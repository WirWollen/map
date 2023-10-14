package vtb.map.map.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.WorkloadEntity;

import java.time.LocalDateTime;
import java.util.List;
public interface WorkloadRepo extends CrudRepository<WorkloadEntity, Long> {
    List<WorkloadEntity> findAll();

    @Query(value = "SELECT COUNT(*) FROM workload " +
            "JOIN department ON workload.department_entity_id = department.id " +
            "WHERE time > ?1 AND time < ?2 AND active = true AND locality_entity_id = ?3", nativeQuery = true)
    Integer calculateClients(LocalDateTime startTime, LocalDateTime endTime, Long localityId);
}
