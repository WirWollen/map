package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.ATMsDto;
import vtb.map.map.entities.ATMsEntity;

public class ATMsConverter {
    public static ATMsDto toDto(ATMsEntity entity) {
        ATMsDto dto = new ATMsDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static ATMsEntity toEntity(ATMsDto dto) {
        ATMsEntity entity = new ATMsEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
