package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.DepartmentDto;
import vtb.map.map.entities.DepartmentEntity;

public class DepartmentConverter {
    public static DepartmentDto toDto(DepartmentEntity entity) {
        DepartmentDto dto = new DepartmentDto();
        BeanUtils.copyProperties(entity, dto);
        dto.setWorkDaysFizDto(WorkDaysConverter.toDto(entity.getWorkDaysFizEntity()));
        dto.setWorkDaysUrDto(WorkDaysConverter.toDto(entity.getWorkDaysUrEntity()));
        return dto;
    }

    public static DepartmentEntity toEntity(DepartmentDto dto) {
        DepartmentEntity entity = new DepartmentEntity();
        BeanUtils.copyProperties(dto, entity);
        entity.setWorkDaysFizEntity(WorkDaysConverter.toEntity(dto.getWorkDaysFizDto()));
        entity.setWorkDaysUrEntity(WorkDaysConverter.toEntity(dto.getWorkDaysUrDto()));
        return entity;
    }
}
