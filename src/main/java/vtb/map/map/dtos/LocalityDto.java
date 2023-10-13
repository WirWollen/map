package vtb.map.map.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocalityDto {
    private Long id;
    private List<DepartmentDto> departmentDtoList;
    private String name;
    private Long stateId;
}
