package vtb.map.map.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import vtb.map.map.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "marketing")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MarketingEntity extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "text")
    private String text;
    @Column(name = "url")
    private String url;
}
