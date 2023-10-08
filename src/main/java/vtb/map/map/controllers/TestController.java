package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.TestDto;
import vtb.map.map.services.TestService;

@AllArgsConstructor
@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "http://localhost:3000")
public class TestController {
    private final TestService testService;

    @PostMapping("/post")
    public TestDto get() {
        return testService.generateTestDto();
    }

    @GetMapping("/get")
    public TestDto post() {
        return testService.generateTestDto();
    }

}
