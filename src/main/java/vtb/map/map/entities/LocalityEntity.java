package vtb.map.map.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vtb.map.map.entities.base.BaseEntity;

import javax.persistence.*;

@Table(name = "locality")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocalityEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "state_entity_id")
    private StateEntity stateEntity;
    @Column(name = "name")
    private String name;
}
