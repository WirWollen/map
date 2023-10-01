package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.CountryDto;
import vtb.map.map.entities.CountryEntity;
import vtb.map.map.services.AdminService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/getCountries")
    public List<CountryDto> getCountries() {
        return adminService.showAllCountries();
    }

    @PostMapping("/getCountryById")
    public CountryDto showCountryDto(long id) {
        return adminService.showCountryDto(id);
    }

    @PostMapping("/saveAll")
    public boolean saveCountryAll(@RequestBody List<CountryDto> dto) {
        return adminService.addCountryList(dto);
    }

    @PutMapping("/change")
    public boolean changeCountry(@RequestBody CountryDto dto) {
        return adminService.changeCountry(dto);
    }

    @DeleteMapping("/deleteById")
    public boolean deleteCountryById(long id) {
        return adminService.deleteCountryById(id);
    }
}
