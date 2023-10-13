package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.PartDto;
import vtb.map.map.entities.PartEntity;

public class PartConverter {
    public static PartDto toDto(PartEntity entity){
        PartDto dto = new PartDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static PartEntity toEntity(PartDto dto){
        PartEntity entity = new PartEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
