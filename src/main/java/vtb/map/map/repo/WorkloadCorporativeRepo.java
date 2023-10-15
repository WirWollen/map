package vtb.map.map.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.WorkloadCorporativeEntity;

import java.time.LocalDateTime;
import java.util.List;
public interface WorkloadCorporativeRepo extends CrudRepository<WorkloadCorporativeEntity, Long> {
    List<WorkloadCorporativeEntity> findAll();

    @Query(value = "SELECT COUNT(*) FROM workloadcorporative " +
            "JOIN department ON workloadcorporative.department_entity_id = department.id " +
            "WHERE time > ?1 AND time < ?2 AND active = true AND department_entity_id = ?3", nativeQuery = true)
    Integer calculateClients(LocalDateTime startTime, LocalDateTime endTime, Long localityId);
}
