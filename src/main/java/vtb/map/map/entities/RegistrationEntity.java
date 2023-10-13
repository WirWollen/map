package vtb.map.map.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vtb.map.map.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "registration")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationEntity extends BaseEntity {
//    @ManyToOne
    @Column(name = "department_entity_id")
    private long departmentId;
    @Column (name = "code")
    private String code;
    @Column(name = "datetime")
    private Timestamp datetime;
}
