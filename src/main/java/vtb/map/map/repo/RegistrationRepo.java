package vtb.map.map.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vtb.map.map.entities.RegistrationEntity;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public interface RegistrationRepo extends CrudRepository<RegistrationEntity, Long> {
    List<RegistrationEntity> findAll();

    @Query(value = "SELECT CASE WHEN EXISTS (SELECT 1 FROM department WHERE id = ?1) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean departmentExists(Long id);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_fiz_id = work_days.id " +
            "WHERE work_days.mon_s > ?1 AND work_days.mon_f < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingMonday(Time start, Time finish);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_fiz_id = work_days.id " +
            "WHERE work_days.tue_s > ?1 AND work_days.tue_f < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingTuesday(Time start, Time finish);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_fiz_id = work_days.id " +
            "WHERE work_days.wed_s > ?1 AND work_days.wed_f < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingWednesday(Time start, Time finish);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_fiz_id = work_days.id " +
            "WHERE work_days.thu_s > ?1 AND work_days.thu_f < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingThursday(Time start, Time finish);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_fiz_id = work_days.id " +
            "WHERE work_days.fri_s > ?1 AND work_days.fri_f < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingFriday(Time start, Time finish);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_fiz_id = work_days.id " +
            "WHERE work_days.sat_s > ?1 AND work_days.sat_f < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingSaturday(Time start, Time finish);

    @Query(value = "SELECT CASE WHEN EXISTS ( " +
            "SELECT 1 FROM department " +
            "JOIN work_days ON department.work_days_entity_fiz_id = work_days.id " +
            "WHERE work_days.sun_s > ?1 AND work_days.sun_f < ?2) THEN true ELSE false END AS result;", nativeQuery = true)
    boolean workingSunday(Time start, Time finish);

    @Query(value = "SELECT EXISTS( SELECT 1 FROM department WHERE id = ?1 ) " +
            "AND NOT EXISTS(SELECT 1 FROM registration WHERE datetime BETWEEN ?2 AND ?3 );", nativeQuery = true)
    boolean checkAvailabilityDate(Long departmentId, Timestamp start, Timestamp finish);

    @Query(value = "SELECT COUNT(*) FROM registration \n" +
            "JOIN department ON registration.department_entity_id = department.id \n" +
            "WHERE datetime > ?1 AND datetime < ?2 AND active = true AND locality_entity_id = ?3", nativeQuery = true)
    Integer calculateRegistration(LocalDateTime startTime, LocalDateTime endTime, Long localityId);
}
