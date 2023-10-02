package vtb.map.map.repo;

import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.DayEntity;

import java.util.List;

public interface DaysRepo extends CrudRepository<DayEntity, Long> {
    List<DayEntity> findAll();
}
