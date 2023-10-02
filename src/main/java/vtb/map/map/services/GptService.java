package vtb.map.map.services;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vtb.map.map.dtos.gpt.CreateChatDto;
import vtb.map.map.dtos.gpt.CreateChatResponseDto;
import vtb.map.map.dtos.gpt.DeleteChatDto;
import vtb.map.map.dtos.gpt.QuestionDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@NoArgsConstructor
public class GptService {
    @Value("${gpt.user}")
    private String user;
    @Value("${gpt.create}")
    private String createUrl;
    @Value("${gpt.delete}")
    private String deleteUrl;
    @Value("${gpt.send}")
    private String sendUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getData(String chatId, String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return parseValue(restTemplate.exchange(sendUrl,
                HttpMethod.POST,
                new HttpEntity<>(new QuestionDto(message, chatId, System.currentTimeMillis() / 1000, null), headers),
                String.class).getBody());
    }

    private String parseValue(String value) {
        StringBuilder res = new StringBuilder();
        String regex = "\"content\":\"(.*?)\"";
        Matcher matcher = Pattern.compile(regex).matcher(value);

        while (matcher.find()) {
            String group1 = matcher.group(1);
            res.append(group1);
        }
        return res.toString();
    }

    @SneakyThrows
    public boolean deleteChat(String id) {
        restTemplate.postForObject(deleteUrl, new DeleteChatDto(id), Boolean.class);

        return true;
    }

    public String createChat() {
        return restTemplate.postForObject(createUrl, new CreateChatDto(user), CreateChatResponseDto.class).getId_();
    }

}

