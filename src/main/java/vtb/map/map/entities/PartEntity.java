package vtb.map.map.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vtb.map.map.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "part")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartEntity extends BaseEntity {
    @Column(name = "service_capability")
    private Boolean service_capability;
    @Column(name = "service_activity")
    private Boolean service_activity;
    @Column(name = "large_bills")
    private Boolean large_bills;
    @Column(name = "small_bills")
    private Boolean small_bills;
}
