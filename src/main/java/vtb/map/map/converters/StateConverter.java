package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.StateDto;
import vtb.map.map.entities.StateEntity;

public class StateConverter {
    public static StateDto toDto(StateEntity entity){
        StateDto dto = new StateDto();
        BeanUtils.copyProperties(entity, dto);
        dto.setCountryDto(CountryConverter.toDto(entity.getCountryEntity()));
        return dto;
    }

    public static StateEntity toEntity(StateDto dto){
        StateEntity entity = new StateEntity();
        BeanUtils.copyProperties(dto, entity);
        entity.setCountryEntity(CountryConverter.toEntity(dto.getCountryDto()));
        return entity;
    }
}
