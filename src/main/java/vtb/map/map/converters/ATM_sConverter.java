package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.ATM_sDto;
import vtb.map.map.entities.ATMs_Entity;

public class ATM_sConverter {
    public static ATM_sDto toDto(ATMs_Entity entity) {
        ATM_sDto dto = new ATM_sDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static ATMs_Entity toEntity(ATM_sDto dto) {
        ATMs_Entity entity = new ATMs_Entity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
