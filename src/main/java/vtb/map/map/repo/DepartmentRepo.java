package vtb.map.map.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.DepartmentEntity;

import java.util.List;
import java.util.Set;

public interface DepartmentRepo extends CrudRepository<DepartmentEntity, Long> {
    List<DepartmentEntity> findAll();

    @Query(value = "SELECT id FROM department where locality_entity_id = ?1", nativeQuery = true)
    Set<Long> getWorkload(Long localityId);

    @Query(value = "SELECT id FROM department where locality_entity_id = ?1", nativeQuery = true)
    Set<Long> getWorkloadCorporative(Long localityId);
}
