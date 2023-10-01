package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vtb.map.map.converters.CountryConverter;
import vtb.map.map.dtos.CountryDto;
import vtb.map.map.entities.CountryEntity;
import vtb.map.map.repo.CountryRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final CountryRepo countryRepo;

    public List<CountryDto> showAllCountries() {
        return countryRepo.findAll().stream().map(CountryConverter::toDto).collect(Collectors.toList());
    }

    public boolean addCountryList(List<CountryDto> dtoList) {
        countryRepo.saveAll(dtoList.stream().map(CountryConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

}
