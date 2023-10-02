package vtb.map.map.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkDaysDto {
    private Long id;
    private DayDto day1;
    private DayDto day2;
    private DayDto day3;
    private DayDto day4;
    private DayDto day5;
    private DayDto day6;
    private DayDto day7;
}
