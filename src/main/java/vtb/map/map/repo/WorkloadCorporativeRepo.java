package vtb.map.map.repo;

import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.WorkloadCorporativeEntity;

import java.util.List;
public interface WorkloadCorporativeRepo extends CrudRepository<WorkloadCorporativeEntity, Long> {
    List<WorkloadCorporativeEntity> findAll();
}
