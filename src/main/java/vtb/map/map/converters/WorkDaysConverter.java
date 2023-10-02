package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.WorkDaysDto;
import vtb.map.map.entities.WorkDaysEntity;

public class WorkDaysConverter {
    public static WorkDaysDto toDto(WorkDaysEntity entity){
        WorkDaysDto dto = new WorkDaysDto();
        BeanUtils.copyProperties(entity, dto);
        dto.setDay1(DayConverter.toDto(entity.getDay1Entity()));
        dto.setDay2(DayConverter.toDto(entity.getDay2Entity()));
        dto.setDay3(DayConverter.toDto(entity.getDay3Entity()));
        dto.setDay4(DayConverter.toDto(entity.getDay4Entity()));
        dto.setDay5(DayConverter.toDto(entity.getDay5Entity()));
        dto.setDay6(DayConverter.toDto(entity.getDay6Entity()));
        dto.setDay7(DayConverter.toDto(entity.getDay7Entity()));
        return dto;
    }

    public static WorkDaysEntity toEntity(WorkDaysDto dto){
        WorkDaysEntity entity = new WorkDaysEntity();
        BeanUtils.copyProperties(dto, entity);
        entity.setDay1Entity(DayConverter.toEntity(dto.getDay1()));
        entity.setDay2Entity(DayConverter.toEntity(dto.getDay2()));
        entity.setDay3Entity(DayConverter.toEntity(dto.getDay3()));
        entity.setDay4Entity(DayConverter.toEntity(dto.getDay4()));
        entity.setDay5Entity(DayConverter.toEntity(dto.getDay5()));
        entity.setDay6Entity(DayConverter.toEntity(dto.getDay6()));
        entity.setDay7Entity(DayConverter.toEntity(dto.getDay7()));
        return entity;
    }
}
