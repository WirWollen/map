package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.services.GptService;

@AllArgsConstructor
@RestController
@RequestMapping("/gpt")
public class GptController {
    private final GptService gptService;

    @GetMapping("/writeMessage")
    public String writeMessage(String chatId, String message) {
        return gptService.getData(chatId, message);
    }

    @PostMapping("/createChat")
    public String createChat() {
        return gptService.createChat();
    }

    @PostMapping("/deleteChat")
    public boolean deleteChat(String id) {
        return gptService.deleteChat(id);
    }

}
