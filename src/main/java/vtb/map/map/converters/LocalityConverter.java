package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.LocalityDto;
import vtb.map.map.entities.LocalityEntity;


public class LocalityConverter {
    public static LocalityDto toDto(LocalityEntity entity){
        LocalityDto dto = new LocalityDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static LocalityEntity toEntity(LocalityDto dto){
        LocalityEntity entity = new LocalityEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
