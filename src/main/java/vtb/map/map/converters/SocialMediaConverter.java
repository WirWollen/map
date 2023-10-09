package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.SocialMediaDto;
import vtb.map.map.entities.SocialMediaEntity;

public class SocialMediaConverter {
    public static SocialMediaDto toDto(SocialMediaEntity entity) {
        SocialMediaDto dto = new SocialMediaDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static SocialMediaEntity toEntity(SocialMediaDto dto) {
        SocialMediaEntity entity = new SocialMediaEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
