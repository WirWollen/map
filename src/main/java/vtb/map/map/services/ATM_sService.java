package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.ATM_sConverter;
import vtb.map.map.dtos.ATM_sDto;
import vtb.map.map.repo.ATM_sRepo;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ATM_sService {
    private final ATM_sRepo aTM_sRepo;
    private final Random random = new Random();

    public List<ATM_sDto> showAllATM_s() {
        return aTM_sRepo.findAll().stream().map(ATM_sConverter::toDto).collect(Collectors.toList());
    }

    public ATM_sDto showATM_sDto(long id) {
        return ATM_sConverter.toDto(aTM_sRepo.findById(id).get());
    }

    public boolean addATM_sList(List<ATM_sDto> dtoList) {
        aTM_sRepo.saveAll(dtoList.stream().map(ATM_sConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateATM_s(ATM_sDto dto) {
        if (aTM_sRepo.existsById(dto.getId())) {
            aTM_sRepo.save(ATM_sConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteATM_sById(long id) {
        aTM_sRepo.deleteById(id);
        return true;
    }
}
