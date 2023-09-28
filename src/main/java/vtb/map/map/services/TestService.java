package vtb.map.map.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vtb.map.map.dtos.TestDto;

@Service
@AllArgsConstructor
public class TestService {
    public TestDto generateTestDto() {
        return new TestDto(1, "test");
    }
}
