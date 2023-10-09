package vtb.map.map.repo;

import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.MarketingEntity;

import java.util.List;
public interface MarketingRepo extends CrudRepository<MarketingEntity, Long> {
    List<MarketingEntity> findAll();
}
