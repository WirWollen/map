package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.ATM_sDto;
import vtb.map.map.services.ATM_sService;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/atm_s")
@CrossOrigin(origins = "http://localhost:3000")
public class ATM_sController {
    private final ATM_sService aTM_sService;

    @GetMapping("/getATM_s")
    public List<ATM_sDto> getATM_s() {
        return aTM_sService.showAllATM_s();
    }

    @PostMapping("/getATM_sById")
    public ATM_sDto showATM_sDto(@RequestParam long id) {
        return aTM_sService.showATM_sDto(id);
    }

    @PostMapping("/saveAllATM_s")
    public boolean saveATM_s(@RequestBody List<ATM_sDto> dto) {
        return aTM_sService.addATM_sList(dto);
    }

    @PutMapping("/updateATM_s")
    public boolean updateATM_s(@RequestBody ATM_sDto dto) {
        return aTM_sService.updateATM_s(dto);
    }

    @DeleteMapping("/deleteATM_sById")
    public boolean deleteATM_sById(@RequestParam long id) {
        return aTM_sService.deleteATM_sById(id);
    }

}
