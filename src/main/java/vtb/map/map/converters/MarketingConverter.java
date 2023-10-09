package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.MarketingDto;
import vtb.map.map.entities.MarketingEntity;

public class MarketingConverter {
    public static MarketingDto toDto(MarketingEntity entity) {
        MarketingDto dto = new MarketingDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static MarketingEntity toEntity(MarketingDto dto) {
        MarketingEntity entity = new MarketingEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
