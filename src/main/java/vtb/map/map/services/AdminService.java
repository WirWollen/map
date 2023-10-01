package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.CountryConverter;
import vtb.map.map.converters.StateConverter;
import vtb.map.map.dtos.CountryDto;
import vtb.map.map.dtos.StateDto;
import vtb.map.map.entities.CountryEntity;
import vtb.map.map.repo.CountryRepo;
import vtb.map.map.repo.StateRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final CountryRepo countryRepo;
    private final StateRepo stateRepo;

    //Country

    public List<CountryDto> showAllCountries() {
        return countryRepo.findAll().stream().map(CountryConverter::toDto).collect(Collectors.toList());
    }

    public CountryDto showCountryDto(long id) {
        return CountryConverter.toDto(countryRepo.findById(id).get());
    }

    public boolean addCountryList(List<CountryDto> dtoList) {
        countryRepo.saveAll(dtoList.stream().map(CountryConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateCountry(CountryDto dto) {
        if (countryRepo.existsById(dto.getId())) {
            countryRepo.save(CountryConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteCountryById(long id) {
        countryRepo.deleteById(id);
        return true;
    }

    //State

    public List<StateDto> showAllStates() {
        return stateRepo.findAll().stream().map(StateConverter::toDto).collect(Collectors.toList());
    }

    public boolean addStateList(List<StateDto> dtoList) {
        stateRepo.saveAll(dtoList.stream().map(StateConverter::toEntity).collect(Collectors.toList()));
        return true;
    }
}
