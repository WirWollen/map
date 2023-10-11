package vtb.map.map.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.StateEntity;

import java.util.List;
import java.util.Set;

public interface StateRepo extends CrudRepository<StateEntity, Long> {
    List<StateEntity> findAll();

    boolean existsByName(String name);

    @Query(value = "SELECT id, name FROM state", nativeQuery = true)
    Set<StateEntity> findAllStateNamesOnly();
}
