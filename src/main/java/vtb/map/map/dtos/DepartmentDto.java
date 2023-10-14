package vtb.map.map.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long id;
    private WorkDaysDto workDaysFizDto;
    private WorkDaysDto workDaysUrDto;
    private String coord_x;
    private String coord_y;
    private String address;
    private String postcode;
    private String description;
    private String phone;
    private String office_type;
    private String sale_point_format;
    private String suo_availability;
    private Boolean has_ramp;
    private Boolean kep;
    private Boolean myBranch;
    private Long localityId;
}
