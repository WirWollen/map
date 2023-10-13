package vtb.map.map.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.ATMs_Entity;
import vtb.map.map.entities.DepartmentEntity;

import java.util.List;
import java.util.Set;

public interface ATM_sRepo extends CrudRepository<ATMs_Entity, Long> {
    List<ATMs_Entity> findAll();

    @Query(value = "SELECT id FROM department where locality_entity_id = ?1", nativeQuery = true)
    Set<DepartmentEntity> getWorkload(Long localityId);
}
