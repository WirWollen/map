package vtb.map.map.converters;

import org.springframework.beans.BeanUtils;
import vtb.map.map.dtos.AvailabilityDto;
import vtb.map.map.entities.AvailabilityEntity;

public class AvailabilityConverter {
    public static AvailabilityDto toDto(AvailabilityEntity entity){
        AvailabilityDto dto = new AvailabilityDto();
        BeanUtils.copyProperties(entity, dto);
        dto.setWheelchair(PartConverter.toDto(entity.getWheelchairEntity()));
        dto.setBlind(PartConverter.toDto(entity.getBlindEntity()));
        dto.setNfc_for_bank_cards(PartConverter.toDto(entity.getNfc_for_bank_cardsEntity()));
        dto.setQr_read(PartConverter.toDto(entity.getQr_readEntity()));
        dto.setSupports_usd(PartConverter.toDto(entity.getSupports_usdEntity()));
        dto.setSupports_charge_rub(PartConverter.toDto(entity.getSupports_charge_rubEntity()));
        dto.setSupports_eur(PartConverter.toDto(entity.getSupports_eurEntity()));
        dto.setSupports_rub(PartConverter.toDto(entity.getSupports_rubEntity()));
        return dto;
    }

    public static AvailabilityEntity toEntity(AvailabilityDto dto){
        AvailabilityEntity entity = new AvailabilityEntity();
        BeanUtils.copyProperties(dto, entity);
        entity.setWheelchairEntity(PartConverter.toEntity(dto.getWheelchair()));
        entity.setBlindEntity(PartConverter.toEntity(dto.getBlind()));
        entity.setNfc_for_bank_cardsEntity(PartConverter.toEntity(dto.getNfc_for_bank_cards()));
        entity.setQr_readEntity(PartConverter.toEntity(dto.getQr_read()));
        entity.setSupports_usdEntity(PartConverter.toEntity(dto.getSupports_usd()));
        entity.setSupports_charge_rubEntity(PartConverter.toEntity(dto.getSupports_charge_rub()));
        entity.setSupports_eurEntity(PartConverter.toEntity(dto.getSupports_eur()));
        entity.setSupports_rubEntity(PartConverter.toEntity(dto.getSupports_rub()));
        return entity;
    }
}
