package vtb.map.map.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.LocalityEntity;

import java.util.List;
import java.util.Set;

public interface LocalityRepo extends CrudRepository<LocalityEntity, Long> {
    List<LocalityEntity> findAll();

    @Query(value = "SELECT id, name FROM locality", nativeQuery = true)
    Set<LocalityEntity> findAllLocalityNamesOnly();
}
