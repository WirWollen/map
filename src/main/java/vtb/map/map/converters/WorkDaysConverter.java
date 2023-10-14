package vtb.map.map.converters;

import vtb.map.map.dtos.DayDto;
import vtb.map.map.dtos.WorkDaysDto;
import vtb.map.map.entities.WorkDaysEntity;

public class WorkDaysConverter {
    public static WorkDaysDto toDto(WorkDaysEntity entity) {
        WorkDaysDto dto = new WorkDaysDto();
        dto.setId(entity.getId());
        dto.setDay1(new DayDto(null, entity.getMon_s(), entity.getMon_f()));
        dto.setDay2(new DayDto(null, entity.getTue_s(), entity.getTue_f()));
        dto.setDay3(new DayDto(null, entity.getWed_s(), entity.getWed_f()));
        dto.setDay4(new DayDto(null, entity.getThu_s(), entity.getThu_f()));
        dto.setDay5(new DayDto(null, entity.getFri_s(), entity.getFri_f()));
        dto.setDay6(new DayDto(null, entity.getSat_s(), entity.getSat_f()));
        dto.setDay7(new DayDto(null, entity.getSun_s(), entity.getSun_f()));

        return dto;
    }

    public static WorkDaysEntity toEntity(WorkDaysDto dto) {
        WorkDaysEntity entity = new WorkDaysEntity();

        entity.setMon_s(dto.getDay1().getStart());
        entity.setMon_f(dto.getDay1().getFinish());

        entity.setTue_s(dto.getDay2().getStart());
        entity.setTue_f(dto.getDay2().getFinish());

        entity.setWed_s(dto.getDay3().getStart());
        entity.setWed_f(dto.getDay3().getFinish());

        entity.setThu_s(dto.getDay4().getStart());
        entity.setThu_f(dto.getDay4().getFinish());

        entity.setFri_s(dto.getDay5().getStart());
        entity.setFri_f(dto.getDay5().getFinish());

        entity.setSat_s(dto.getDay6().getStart());
        entity.setSat_f(dto.getDay6().getFinish());

        entity.setSun_s(dto.getDay7().getStart());
        entity.setSun_f(dto.getDay7().getFinish());

        return entity;
    }
}
