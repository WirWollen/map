package vtb.map.map.repo;

import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.WorkDaysEntity;

import java.util.List;

public interface WorkDaysRepo extends CrudRepository<WorkDaysEntity, Long> {
    List<WorkDaysEntity> findAll();
}
