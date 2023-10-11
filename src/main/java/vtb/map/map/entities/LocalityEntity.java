package vtb.map.map.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vtb.map.map.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Table(name = "locality")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocalityEntity extends BaseEntity {
    @Column(name = "name")
    private String name;
    @OneToMany
    @JoinColumn(name = "locality_entity_id")
    private List<DepartmentEntity> departmentEntityList;
    @Column(name = "state_entity_id")
    private Long stateId;
}
