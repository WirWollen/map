package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/saveCountry")
    public CountryEntity saveCountry(CountryDto dto) {
        return adminService.addCountry(dto);
    }
}
