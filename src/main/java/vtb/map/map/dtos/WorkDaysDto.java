package vtb.map.map.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkDaysDto {
    private Long id;
    private Time mon_s;
    private Time mon_f;
    private Time tue_s;
    private Time tue_f;
    private Time wed_s;
    private Time wed_f;
    private Time thu_s;
    private Time thu_f;
    private Time fri_s;
    private Time fri_f;
    private Time sat_s;
    private Time sat_f;
    private Time sun_s;
    private Time sun_f;
}
