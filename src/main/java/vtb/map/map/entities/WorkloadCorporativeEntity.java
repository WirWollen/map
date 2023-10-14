package vtb.map.map.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vtb.map.map.entities.base.BaseEntity;

import javax.persistence.*;

@Table(name = "workloadcorporative")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkloadCorporativeEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "department_entity_id")
    private DepartmentEntity departmentEntity;
    @Column(name = "people_count")
    private Integer people_count;
}
