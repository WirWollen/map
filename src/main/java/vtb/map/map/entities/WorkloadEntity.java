package vtb.map.map.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vtb.map.map.entities.base.BaseEntity;

import javax.persistence.*;

@Table(name = "workload")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkloadEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn (name = "department_entity_id")
    private DepartmentEntity departmentEntity;
    @Column (name = "people_count")
    private Integer people_count;
}
