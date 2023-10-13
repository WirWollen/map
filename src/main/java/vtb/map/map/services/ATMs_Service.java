package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.ATMs_Converter;
import vtb.map.map.dtos.ATMs_Dto;
import vtb.map.map.repo.ATMs_Repo;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ATMs_Service {
    private final ATMs_Repo aTM_sRepo;
    private final Random random = new Random();

    public List<ATMs_Dto> showAllATM_s() {
        return aTM_sRepo.findAll().stream().map(ATMs_Converter::toDto).collect(Collectors.toList());
    }

    public ATMs_Dto showATM_sDto(long id) {
        return ATMs_Converter.toDto(aTM_sRepo.findById(id).get());
    }

    public boolean addATM_sList(List<ATMs_Dto> dtoList) {
        aTM_sRepo.saveAll(dtoList.stream().map(ATMs_Converter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateATM_s(ATMs_Dto dto) {
        if (aTM_sRepo.existsById(dto.getId())) {
            aTM_sRepo.save(ATMs_Converter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteATM_sById(long id) {
        aTM_sRepo.deleteById(id);
        return true;
    }
}
