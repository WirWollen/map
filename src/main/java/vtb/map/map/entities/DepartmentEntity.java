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
    @JoinColumn(name = "work_days_entity_fiz_id")
    private WorkDaysEntity workDaysFizEntity;
    @OneToOne
    @JoinColumn(name = "work_days_entity_ur_id")
    private WorkDaysEntity workDaysUrEntity;
    @Column(name = "locality_entity_id")
    private Long localityId;
    @Column(name = "address")
    private String address;
    @Column(name = "coord_x")
    private String coord_x;
    @Column(name = "coord_y")
    private String coord_y;
    @Column(name = "postcode")
    private String postcode;
    @Column(name = "description")
    private String description;
    @Column(name = "phone")
    private String phone;
    @Column(name = "office_type")
    private String office_type;
    @Column(name = "sale_point_format")
    private String sale_point_format;
    @Column(name = "suo_availability")
    private String suo_availability;
    @Column(name = "has_ramp")
    private Boolean has_ramp;
    @Column(name = "kep")
    private Boolean kep;
    @Column(name = "myBranch")
    private Boolean myBranch;
}
