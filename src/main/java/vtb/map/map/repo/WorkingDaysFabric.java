package vtb.map.map.repo;

import java.sql.Time;
import java.sql.Timestamp;

public interface WorkingDaysFabric {
    boolean departmentExists(Long id);
    boolean workingMonday(Time start, Time finish);
    boolean workingTuesday(Time start, Time finish);
    boolean workingWednesday(Time start, Time finish);
    boolean workingThursday(Time start, Time finish);
    boolean workingFriday(Time start, Time finish);
    boolean workingSaturday(Time start, Time finish);
    boolean workingSunday(Time start, Time finish);
    boolean checkAvailabilityDate(Long departmentId, Timestamp start, Timestamp finish);
}
