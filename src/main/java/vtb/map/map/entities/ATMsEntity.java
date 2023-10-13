package vtb.map.map.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vtb.map.map.entities.base.BaseEntity;

import javax.persistence.*;

@Table(name = "atms")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ATMsEntity extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "availability_entity_id")
    private AvailabilityEntity availabilityEntity;
    @Column(name = "locality_entity_id")
    private Long localityId;
    @Column(name = "address")
    private String address;
    @Column(name = "coord_x")
    private String coord_x;
    @Column(name = "coord_y")
    private String coord_y;
    @Column(name = "description")
    private String description;
    @Column(name = "allday")
    private Boolean allday;
}
