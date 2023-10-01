package vtb.map.map.repo;

import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.LocalityEntity;

import java.util.List;
public interface LocalityRepo extends CrudRepository<LocalityEntity, Long> {
    List<LocalityEntity> findAll();
}
