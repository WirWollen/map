package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.CountryDto;
import vtb.map.map.services.CountryService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/country")
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
}
