package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.ATMs_Dto;
import vtb.map.map.entities.ATMs_Entity;

public class ATMs_Converter {
    public static ATMs_Dto toDto(ATMs_Entity entity) {
        ATMs_Dto dto = new ATMs_Dto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static ATMs_Entity toEntity(ATMs_Dto dto) {
        ATMs_Entity entity = new ATMs_Entity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
