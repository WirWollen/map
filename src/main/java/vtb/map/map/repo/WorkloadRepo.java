package vtb.map.map.repo;

import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.WorkloadEntity;

import java.util.List;
public interface WorkloadRepo extends CrudRepository<WorkloadEntity, Long> {
    List<WorkloadEntity> findAll();
}
