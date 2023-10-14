package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.AvailabilityDto;
import vtb.map.map.entities.AvailabilityEntity;

public class AvailabilityConverter {
    public static AvailabilityDto toDto(AvailabilityEntity entity){
        AvailabilityDto dto = new AvailabilityDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static AvailabilityEntity toEntity(AvailabilityDto dto){
        AvailabilityEntity entity = new AvailabilityEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
