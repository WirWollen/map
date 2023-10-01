package vtb.map.map.repo;

import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.StateEntity;

import java.util.List;

public interface StateRepo extends CrudRepository<StateEntity, Long> {
    List<StateEntity> findAll();
    boolean existsByName(String name);
}
