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
public class StateDto {
    private Long id;
    private List<LocalityDto> localityDtoList;
    private String name;
    private Long countryId;
}
