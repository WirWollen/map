package vtb.map.map.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vtb.map.map.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "socialMedia")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocialMediaEntity extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;
}
