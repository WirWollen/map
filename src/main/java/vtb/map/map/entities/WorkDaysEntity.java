package vtb.map.map.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vtb.map.map.entities.base.BaseEntity;

import javax.persistence.*;

@Table(name = "work_days")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkDaysEntity extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "day1_entity_id")
    private DayEntity day1Entity;
    @OneToOne
    @JoinColumn(name = "day2_entity_id")
    private DayEntity day2Entity;
    @OneToOne
    @JoinColumn(name = "day3_entity_id")
    private DayEntity day3Entity;
    @OneToOne
    @JoinColumn(name = "day4_entity_id")
    private DayEntity day4Entity;
    @OneToOne
    @JoinColumn(name = "day5_entity_id")
    private DayEntity day5Entity;
    @OneToOne
    @JoinColumn(name = "day6_entity_id")
    private DayEntity day6Entity;
    @OneToOne
    @JoinColumn(name = "day7_entity_id")
    private DayEntity day7Entity;
}
