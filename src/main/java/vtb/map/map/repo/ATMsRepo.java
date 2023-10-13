package vtb.map.map.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.ATMsEntity;
import vtb.map.map.entities.DepartmentEntity;

import java.util.List;
import java.util.Set;

public interface ATMsRepo extends CrudRepository<ATMsEntity, Long> {
    List<ATMsEntity> findAll();

    @Query(value = "SELECT id FROM department where locality_entity_id = ?1", nativeQuery = true)
    Set<DepartmentEntity> getWorkload(Long localityId);
}
