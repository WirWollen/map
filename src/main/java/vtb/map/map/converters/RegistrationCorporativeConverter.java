package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.RegistrationCorporativeDto;
import vtb.map.map.entities.RegistrationCorporativeEntity;

public class RegistrationCorporativeConverter {
    public static RegistrationCorporativeDto toDto(RegistrationCorporativeEntity entity) {
        RegistrationCorporativeDto dto = new RegistrationCorporativeDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static RegistrationCorporativeEntity toEntity(RegistrationCorporativeDto dto) {
        RegistrationCorporativeEntity entity = new RegistrationCorporativeEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
