package vtb.map.map.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.CountryEntity;
import vtb.map.map.entities.StateEntity;

import java.util.List;
import java.util.Set;

public interface StateRepo extends CrudRepository<StateEntity, Long> {
    List<StateEntity> findAll();

    boolean existsByName(String name);

    @Query(value = "SELECT id, name FROM state", nativeQuery = true)
    Set<StateEntity> findAllStateNamesOnly();

    @Query(value = "SELECT id FROM state WHERE name = ?1", nativeQuery = true)
    Set<StateEntity> findEqual(String name);

    @Query(value = "SELECT id FROM state WHERE name != ?1", nativeQuery = true)
    Set<StateEntity> findNotEqual(String name);

    @Query(value = "SELECT id FROM state WHERE name LIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    Set<StateEntity> findContains(String name);

    @Query(value = "SELECT id FROM state WHERE name NOT LIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    Set<StateEntity> findNotContains(String name);
}
