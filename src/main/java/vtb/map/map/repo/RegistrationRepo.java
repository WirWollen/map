package vtb.map.map.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.DepartmentEntity;
import vtb.map.map.entities.RegistrationEntity;

import java.time.Instant;
import java.util.List;
import java.util.Set;

public interface RegistrationRepo extends CrudRepository<RegistrationEntity, Long> {
    List<RegistrationEntity> findAll();

    @Query(value = "SELECT CASE WHEN EXISTS (SELECT 1 FROM department WHERE id = ?1) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean departmentExists(Long id);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_fiz_id = work_days.id " +
            "JOIN day ON work_days.day1_entity_id = day.id " +
            "WHERE day.start > ?1 AND day.finish < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingMonday(Instant start, Instant finish);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_fiz_id = work_days.id " +
            "JOIN day ON work_days.day2_entity_id = day.id " +
            "WHERE day.start > ?1 AND day.finish < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingTuesday(Instant start, Instant finish);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_fiz_id = work_days.id " +
            "JOIN day ON work_days.day3_entity_id = day.id " +
            "WHERE day.start > ?1 AND day.finish < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingWednesday(Instant start, Instant finish);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_fiz_id = work_days.id " +
            "JOIN day ON work_days.day4_entity_id = day.id " +
            "WHERE day.start > ?1 AND day.finish < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingThursday(Instant start, Instant finish);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_fiz_id = work_days.id " +
            "JOIN day ON work_days.day5_entity_id = day.id " +
            "WHERE day.start > ?1 AND day.finish < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingFriday(Instant start, Instant finish);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_fiz_id = work_days.id " +
            "JOIN day ON work_days.day6_entity_id = day.id " +
            "WHERE day.start > ?1 AND day.finish < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingSaturday(Instant start, Instant finish);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_fiz_id = work_days.id " +
            "JOIN day ON work_days.day7_entity_id = day.id " +
            "WHERE day.start > ?1 AND day.finish < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingSunday(Instant start, Instant finish);

}
