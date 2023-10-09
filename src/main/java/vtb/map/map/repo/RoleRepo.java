package vtb.map.map.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vtb.map.map.dtos.RoleEnum;
import vtb.map.map.entities.RoleEntity;

import java.util.List;

public interface RoleRepo extends CrudRepository<RoleEntity, Long> {
    List<RoleEntity> findAll();

    @Query(value = "SELECT EXISTS (SELECT 1 FROM role WHERE role = ?1)", nativeQuery = true)
    boolean roleExists(RoleEnum role);

    @Query(value = "DELETE FROM role WHERE role = ?1", nativeQuery = true)
    void deleteByRole(RoleEnum role);

    @Query(value = "UPDATE role SET role = ?1 WHERE role = ?2", nativeQuery = true)
    void renameRole(RoleEnum to, RoleEnum before);
}
