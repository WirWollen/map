package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vtb.map.map.services.GptService;

@AllArgsConstructor
@RestController
@RequestMapping("/gpt")
public class GptController {
    private final GptService gptService;

    @GetMapping
    public void test(String message) {
        gptService.getData(message);
    }

}
