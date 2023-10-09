package vtb.map.map.converters;

import vtb.map.map.dtos.RoleEnum;
import vtb.map.map.entities.RoleEntity;

public class RoleConverter {
    public static RoleEntity toEntity(RoleEnum dto) {
        return new RoleEntity(dto.name());
    }

    public static RoleEnum toDto(RoleEntity entity) {
        return RoleEnum.valueOf(entity.getRole());
    }
}
