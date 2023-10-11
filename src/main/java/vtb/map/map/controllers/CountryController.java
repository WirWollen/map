package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.CountryDto;
import vtb.map.map.entities.CountryEntity;
import vtb.map.map.enums.SearchFilter;
import vtb.map.map.services.CountryService;

import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/country")
@CrossOrigin(origins = "http://localhost:3000")
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/getCountries")
    public List<CountryDto> getCountries() {
        return countryService.showAllCountries();
    }

    @PostMapping("/getCountryById")
    public CountryDto showCountryDto(@RequestParam long id) {
        return countryService.showCountryDto(id);
    }

    @PostMapping("/saveAllCountries")
    public boolean saveCountry(@RequestBody List<CountryDto> dto) {
        return countryService.addCountryList(dto);
    }

    @PutMapping("/changeCountry")
    public boolean updateCountry(@RequestBody CountryDto dto) {
        return countryService.updateCountry(dto);
    }

    @DeleteMapping("/deleteCountryById")
    public boolean deleteCountryById(@RequestParam long id) {
        return countryService.deleteCountryById(id);
    }

    @GetMapping("/findAllNamesOnly")
    public Map<Long, String> findAllCountryNamesOnly() {
        return countryService.findAllCountryNamesOnly();
    }

    @GetMapping("/findByName")
    public Set<Long> findCountryByName(SearchFilter filter, String name) {
        return countryService.findByName(filter, name);
    }
}
