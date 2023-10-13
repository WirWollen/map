package vtb.map.map.repo;

import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.AvailabilityEntity;

import java.util.List;
public interface AvailabilityRepo extends CrudRepository<AvailabilityEntity, Long> {
    List<AvailabilityEntity> findAll();
}
