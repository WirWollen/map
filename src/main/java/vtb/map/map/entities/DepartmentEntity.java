package vtb.map.map.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vtb.map.map.entities.base.BaseEntity;

import javax.persistence.*;

@Table(name = "department")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEntity extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "work_days_entity_id")
    private WorkDaysEntity workDaysEntity;
    @Column(name = "address")
    private String address;
    @Column(name = "coord")
    private String coord;
    @Column(name = "postcode")
    private String postcode;
    @Column(name = "description")
    private String description;
    @Column(name = "phone")
    private String phone;
    @Column(name = "atms_count")
    private Integer ATMs_count;
    @Column(name = "is_atm")
    private boolean is_ATM;
    @Column(name = "locality_entity_id")
    private long localityId;
}
