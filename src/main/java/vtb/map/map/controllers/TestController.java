package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vtb.map.map.dtos.TestDto;
import vtb.map.map.services.TestService;

@AllArgsConstructor
@RestController
@RequestMapping("/test")
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
