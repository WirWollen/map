package vtb.map.map.repo;

import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.RegistrationEntity;

import java.util.List;
public interface RegistrationRepo extends CrudRepository<RegistrationEntity, Long> {
    List<RegistrationEntity> findAll();
}
