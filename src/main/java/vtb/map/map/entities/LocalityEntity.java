package vtb.map.map.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vtb.map.map.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    private List<DepartmentEntity> departmentEntityList;
}
