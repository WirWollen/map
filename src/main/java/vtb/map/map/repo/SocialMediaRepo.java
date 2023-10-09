package vtb.map.map.repo;

import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.SocialMediaEntity;

import java.util.List;
public interface SocialMediaRepo extends CrudRepository<SocialMediaEntity, Long> {
    List<SocialMediaEntity> findAll();
}
