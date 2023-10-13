package vtb.map.map.repo;

import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.PartEntity;

import java.util.List;

public interface PartRepo extends CrudRepository<PartEntity, Long> {
    List<PartEntity> findAll();
}
