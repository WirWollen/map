package vtb.map.map.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vtb.map.map.entities.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Time;

@Table(name = "day")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DayEntity extends BaseEntity {
    private Time start;
    private Time finish;
}
