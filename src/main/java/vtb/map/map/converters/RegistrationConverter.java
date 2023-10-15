package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.RegistrationDto;
import vtb.map.map.entities.RegistrationEntity;

public class RegistrationConverter {
    public static RegistrationDto toDto(RegistrationEntity entity) {
        RegistrationDto dto = new RegistrationDto();
        BeanUtils.copyProperties(entity, dto);
        dto.setDepartment_id(entity.getDepartment_entity_id());
        return dto;
    }

    public static RegistrationEntity toEntity(RegistrationDto dto) {
        RegistrationEntity entity = new RegistrationEntity();
        BeanUtils.copyProperties(dto, entity);
        entity.setDepartment_entity_id(dto.getDepartment_id());
        return entity;
    }
}
