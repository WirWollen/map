package vtb.map.map.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.UserEntity;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    @Query(value = "SELECT * FROM users WHERE login = ?1)", nativeQuery = true)
    UserEntity findByLogin(String login);
}
