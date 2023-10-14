package vtb.map.map.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.RegistrationCorporativeEntity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public interface RegistrationCorporativeRepo extends CrudRepository<RegistrationCorporativeEntity, Long> {
    List<RegistrationCorporativeEntity> findAll();

    @Query(value = "SELECT CASE WHEN EXISTS (SELECT 1 FROM department WHERE id = ?1) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean departmentExists(Long id);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_ur_id = work_days.id " +
            "JOIN day ON work_days.day1_entity_id = day.id " +
            "WHERE day.start > ?1 AND day.finish < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingMonday(Time start, Time finish);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_ur_id = work_days.id " +
            "JOIN day ON work_days.day2_entity_id = day.id " +
            "WHERE day.start > ?1 AND day.finish < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingTuesday(Time start, Time finish);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_ur_id = work_days.id " +
            "JOIN day ON work_days.day3_entity_id = day.id " +
            "WHERE day.start > ?1 AND day.finish < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingWednesday(Time start, Time finish);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_ur_id = work_days.id " +
            "JOIN day ON work_days.day4_entity_id = day.id " +
            "WHERE day.start > ?1 AND day.finish < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingThursday(Time start, Time finish);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_ur_id = work_days.id " +
            "JOIN day ON work_days.day5_entity_id = day.id " +
            "WHERE day.start > ?1 AND day.finish < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingFriday(Time start, Time finish);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_ur_id = work_days.id " +
            "JOIN day ON work_days.day6_entity_id = day.id " +
            "WHERE day.start > ?1 AND day.finish < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingSaturday(Time start, Time finish);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_ur_id = work_days.id " +
            "JOIN day ON work_days.day7_entity_id = day.id " +
            "WHERE day.start > ?1 AND day.finish < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingSunday(Time start, Time finish);

    @Query(value = "SELECT EXISTS( SELECT 1 FROM test WHERE id = ?1 ) " +
            "AND NOT EXISTS(SELECT 1 FROM register WHERE datetime BETWEEN ?2 AND ?3 );", nativeQuery = true)
    boolean checkAvailabilityDate(Long departmentId, Timestamp start, Timestamp finish);
}
