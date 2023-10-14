package vtb.map.map.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.CountryEntity;
import vtb.map.map.entities.LocalityEntity;

import java.util.List;
import java.util.Set;

public interface LocalityRepo extends CrudRepository<LocalityEntity, Long> {
    List<LocalityEntity> findAll();

    @Query(value = "SELECT id, name FROM locality", nativeQuery = true)
    Set<LocalityEntity> findAllLocalityNamesOnly();

    @Query(value = "SELECT id FROM locality WHERE name = ?1", nativeQuery = true)
    Set<LocalityEntity> findEqual(String name);

    @Query(value = "SELECT id FROM locality WHERE name != ?1", nativeQuery = true)
    Set<LocalityEntity> findNotEqual(String name);

    @Query(value = "SELECT id FROM locality WHERE name LIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    Set<LocalityEntity> findContains(String name);

    @Query(value = "SELECT id FROM locality WHERE name NOT LIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    Set<LocalityEntity> findNotContains(String name);

    @Query(value = "SELECT * FROM locality WHERE name LIKE CONCAT('%', ?1, '%') LIMIT 1", nativeQuery = true)
//    @Query(value = "SELECT * FROM locality WHERE name = ?1 LIMIT 1", nativeQuery = true)
    LocalityEntity findEqualLocality(String name);
}
