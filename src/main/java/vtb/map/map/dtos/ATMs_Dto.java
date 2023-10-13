package vtb.map.map.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ATMs_Dto {
    private Long id;
    private AvailabilityDto availabilityDto;
    private String description;
    private String address;
    private String coord_x;
    private String coord_y;
    private Boolean allday;
    private Long localityId;
}
