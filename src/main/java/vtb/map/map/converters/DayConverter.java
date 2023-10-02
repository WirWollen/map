package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.DayDto;
import vtb.map.map.entities.DayEntity;

public class DayConverter {
    public static DayDto toDto(DayEntity entity){
        DayDto dto = new DayDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static DayEntity toEntity(DayDto dto){
        DayEntity entity = new DayEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
