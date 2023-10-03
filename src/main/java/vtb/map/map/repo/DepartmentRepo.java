package vtb.map.map.repo;

import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.DepartmentEntity;

import java.util.List;
public interface DepartmentRepo extends CrudRepository<DepartmentEntity, Long> {
    List<DepartmentEntity> findAll();
}
