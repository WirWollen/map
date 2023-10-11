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
    private WorkDaysDto workDaysDto;
    private String coord;
    private String postcode;
    private String description;
    private String phone;
    private Long ATMs_count;
    private boolean is_ATM;
    private Long localityId;
}
