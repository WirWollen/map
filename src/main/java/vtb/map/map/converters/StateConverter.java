package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.StateDto;
import vtb.map.map.entities.StateEntity;

public class StateConverter {
    public static StateDto toDto(StateEntity entity){
        StateDto dto = new StateDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static StateEntity toEntity(StateDto dto){
        StateEntity entity = new StateEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
