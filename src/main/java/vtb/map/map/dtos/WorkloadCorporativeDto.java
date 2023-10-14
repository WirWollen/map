package vtb.map.map.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkloadCorporativeDto {
    private Long id;
    private Long department_id;
    private Timestamp time;
    private String name;
    private boolean is_active;
}
