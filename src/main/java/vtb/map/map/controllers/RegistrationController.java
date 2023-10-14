package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.RegistrationDto;
import vtb.map.map.exceptions.TheSpecifiedDateIsNotPossibleException;
import vtb.map.map.services.RegistrationService;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/registration")
@CrossOrigin(origins = "http://localhost:3000")
public class RegistrationController {
    private final RegistrationService registrationService;
    @GetMapping("/getRegistration")
    public List<RegistrationDto> getRegistration() {return registrationService.showAllRegistration();}

    @PostMapping("/getRegistrationById")
    public RegistrationDto showRegistrationDto(@RequestParam long id) {
        return registrationService.showRegistrationDto(id);
    }
    @GetMapping("/register")
    public String saveRegistration(Long departmentId, Instant time) throws TheSpecifiedDateIsNotPossibleException {
        return registrationService.register(departmentId, time);
    }

    @PutMapping("/updateRegistration")
    public boolean updateRegistration(@RequestBody RegistrationDto dto) {
        return registrationService.updateRegistration(dto);
    }

    @DeleteMapping("/deleteRegistrationById")
    public boolean deleteRegistrationById(@RequestParam long id) {
        return registrationService.deleteRegistrationById(id);
    }
}
