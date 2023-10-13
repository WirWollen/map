package vtb.map.map.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vtb.map.map.entities.base.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "registration")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "department_entity_id")
    private DepartmentEntity departmentEntity;
    @Column (name = "code")
    private String code;
    @Column(name = "datetime")
    private Timestamp datetime;
}
