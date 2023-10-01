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

    @PostMapping("/saveAll")
    public boolean saveCountryAll(@RequestBody List<CountryDto> dto) {
        return adminService.addCountryList(dto);
    }
}
