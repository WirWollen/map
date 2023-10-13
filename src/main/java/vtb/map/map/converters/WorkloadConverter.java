package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.WorkloadDto;
import vtb.map.map.entities.WorkloadEntity;

public class WorkloadConverter {
    public static WorkloadDto toDto(WorkloadEntity entity) {
        WorkloadDto dto = new WorkloadDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static WorkloadEntity toEntity(WorkloadDto dto) {
        WorkloadEntity entity = new WorkloadEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
