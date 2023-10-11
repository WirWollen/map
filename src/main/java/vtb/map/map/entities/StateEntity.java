package vtb.map.map.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vtb.map.map.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Table(name = "state")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StateEntity extends BaseEntity {
    @Column(name = "name")
    private String name;
    @OneToMany
    @JoinColumn(name = "state_entity_id")
    private List<LocalityEntity> localityEntityList;
    @Column(name = "country_entity_id")
    private Long countryId;
}
