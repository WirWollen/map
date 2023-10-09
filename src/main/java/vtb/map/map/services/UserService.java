package vtb.map.map.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vtb.map.map.converters.UserConverter;
import vtb.map.map.dtos.UserDto;
import vtb.map.map.repo.UserRepo;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public Optional<UserDto> getByLogin(@NonNull String login) {
        return Optional.of(UserConverter.toDto(userRepo.findByLogin(login)));
    }

    public boolean registerUser(@NonNull UserDto dto) {
        return true;
    }

}
