package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.UserDto;
import vtb.map.map.entities.UserEntity;

import java.util.stream.Collectors;

public class UserConverter {
    public static UserDto toDto(UserEntity entity) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(entity, dto);
        dto.setRoles(entity.getRole().stream().map(RoleConverter::toDto).collect(Collectors.toSet()));
        return dto;
    }

    public static UserEntity toEntity(UserDto dto) {
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(dto, entity);
        entity.setRole(dto.getRoles().stream().map(RoleConverter::toEntity).collect(Collectors.toSet()));
        return entity;
    }
}
