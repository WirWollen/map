package vtb.map.map.services;

import lombok.NoArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vtb.map.map.dtos.QuestionDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@NoArgsConstructor
public class GptService {
    private final RestTemplate restTemplate = new RestTemplate();
    private String value = "";

    public void getData(String message) {
        String url = "https://chat.chatgptdemo.net/chat_api_stream";

        String user_id = "aunwpvqmkzaqrlklz";

        QuestionDto dto = new QuestionDto();
        dto.setQuestion(message);
        dto.setTimestamp(System.currentTimeMillis() / 1000);
        dto.setChat_id("6519d8bb161ea567f678b85a");
//        dto.setToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoicm4xbzBvYzFrb3MxM2s1czAiLCJleHAiOjE2OTYxOTEzNjguODE3MTg5NX0.k2OOXL9_CsrTRVAJTOS9-yC963PYgL-RHWZchbeckc0");

        // Создание заголовков запроса
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Создание объекта запроса с заголовками и телом
        HttpEntity<QuestionDto> requestEntity = new HttpEntity<>(dto, headers);

        // Создание объекта RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Отправка запроса и получение ответа
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        // Получение тела ответа
        String response = responseEntity.getBody();

        value += parseValue(response);

        System.out.println(response);
//        System.out.println(parseValue(response));
        System.out.println(1);

        System.out.println("------" + value);
    }

    private String parseValue(String value) {
        // Регулярное выражение для поиска и извлечения данных из строки
        String regex = "\"content\":\"(.*?)\"";

        // Создание объекта Pattern
        Pattern pattern = Pattern.compile(regex);

        // Создание объекта Matcher
        Matcher matcher = pattern.matcher(value);

        // Поиск совпадений и вывод результатов
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "----";
    }
}

