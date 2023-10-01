package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.CountryDto;
import vtb.map.map.dtos.StateDto;
import vtb.map.map.entities.CountryEntity;
import vtb.map.map.services.AdminService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    //Country

    @GetMapping("/getCountries")
    public List<CountryDto> getCountries() {
        return adminService.showAllCountries();
    }

    @PostMapping("/getCountryById")
    public CountryDto showCountryDto(@RequestParam long id) {
        return adminService.showCountryDto(id);
    }

    @PostMapping("/saveAllCountries")
    public boolean saveCountry(@RequestBody List<CountryDto> dto) {
        return adminService.addCountryList(dto);
    }

    @PutMapping("/changeCountry")
    public boolean updateCountry(@RequestBody CountryDto dto) {
        return adminService.updateCountry(dto);
    }

    @DeleteMapping("/deleteCountryById")
    public boolean deleteCountryById(@RequestParam long id) {
        return adminService.deleteCountryById(id);
    }

    //State

    @GetMapping("/getStates")
    public List<StateDto> getStates() {
        return adminService.showAllStates();
    }

    @PostMapping("/saveAllStates")
    public boolean saveState(@RequestBody List<StateDto> dto) {
        return adminService.addStateList(dto);
    }
}
