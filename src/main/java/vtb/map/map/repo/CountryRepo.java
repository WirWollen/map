package vtb.map.map.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.CountryEntity;

import java.util.List;
import java.util.Set;

public interface CountryRepo extends CrudRepository<CountryEntity, Long> {
    List<CountryEntity> findAll();

    boolean existsByIdAndName(Long id, String name);

    @Query(value = "SELECT id, name FROM country", nativeQuery = true)
    Set<CountryEntity> findAllCountryNamesOnly();

    @Query(value = "SELECT id FROM country WHERE name = ?1", nativeQuery = true)
    Set<CountryEntity> findEqual(String name);

    @Query(value = "SELECT id FROM country WHERE name != ?1", nativeQuery = true)
    Set<CountryEntity> findNotEqual(String name);

    @Query(value = "SELECT id FROM country WHERE name LIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    Set<CountryEntity> findContains(String name);

    @Query(value = "SELECT id FROM country WHERE name NOT LIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    Set<CountryEntity> findNotContains(String name);
}
