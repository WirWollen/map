package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.WorkloadCorporativeDto;
import vtb.map.map.entities.WorkloadCorporativeEntity;

public class WorkloadCorporativeConverter {
    public static WorkloadCorporativeDto toDto(WorkloadCorporativeEntity entity) {
        WorkloadCorporativeDto dto = new WorkloadCorporativeDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static WorkloadCorporativeEntity toEntity(WorkloadCorporativeDto dto) {
        WorkloadCorporativeEntity entity = new WorkloadCorporativeEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
