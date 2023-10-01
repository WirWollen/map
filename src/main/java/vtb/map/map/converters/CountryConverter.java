package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.CountryDto;
import vtb.map.map.entities.CountryEntity;

public class CountryConverter {
    public static CountryDto toDto(CountryEntity entity){
        CountryDto dto = new CountryDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static CountryEntity toEntity(CountryDto dto){
        CountryEntity entity = new CountryEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
