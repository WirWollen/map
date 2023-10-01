package vtb.map.map.repo;

import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.CountryEntity;

import java.util.List;

public interface CountryRepo extends CrudRepository<CountryEntity, Long> {
    List<CountryEntity> findAll();
    boolean existsByIdAndName(Long id, String name);
}
