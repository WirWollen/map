package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.DayDto;
import vtb.map.map.dtos.WorkDaysDto;
import vtb.map.map.entities.WorkDaysEntity;

public class WorkDaysConverter {
    public static WorkDaysDto toDto(WorkDaysEntity entity) {
        WorkDaysDto dto = new WorkDaysDto();
        dto.setId(entity.getId());
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static WorkDaysEntity toEntity(WorkDaysDto dto) {
        WorkDaysEntity entity = new WorkDaysEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
