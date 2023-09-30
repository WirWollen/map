package vtb.map.map.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vtb.map.map.entities.base.BaseEntity;

import javax.persistence.*;

@Table(name = "state")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StateEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "country_entity_id")
    private CountryEntity countryEntity;
    @Column(name = "name")
    private String name;
}
