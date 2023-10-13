package vtb.map.map.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartDto {
    private Long id;
    private Boolean service_capability;
    private Boolean service_activity;
    private Boolean large_bills;
    private Boolean small_bills;
}
