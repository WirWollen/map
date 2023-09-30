package vtb.map.map.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vtb.map.map.dtos.UserDto;
import vtb.map.map.enums.Role;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final List<UserDto> userDtos;

    public UserService() {
        this.userDtos = List.of(
                new UserDto("anton", "1234", "Антон", "Иванов", Collections.singleton(Role.USER)),
                new UserDto("ivan", "12345", "Сергей", "Петров", Collections.singleton(Role.ADMIN))
        );
    }

    public Optional<UserDto> getByLogin(@NonNull String login) {
        return userDtos.stream()
                .filter(userDto -> login.equals(userDto.getLogin()))
                .findFirst();
    }

}
