package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.ATMsConverter;
import vtb.map.map.dtos.ATMsDto;
import vtb.map.map.repo.ATMsRepo;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ATMsService {
    private final ATMsRepo aTM_sRepo;
    private final Random random = new Random();

    public List<ATMsDto> showAllATM_s() {
        return aTM_sRepo.findAll().stream().map(ATMsConverter::toDto).collect(Collectors.toList());
    }

    public ATMsDto showATM_sDto(long id) {
        return ATMsConverter.toDto(aTM_sRepo.findById(id).get());
    }

    public boolean addATM_sList(List<ATMsDto> dtoList) {
        aTM_sRepo.saveAll(dtoList.stream().map(ATMsConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateATM_s(ATMsDto dto) {
        if (aTM_sRepo.existsById(dto.getId())) {
            aTM_sRepo.save(ATMsConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteATM_sById(long id) {
        aTM_sRepo.deleteById(id);
        return true;
    }
}
