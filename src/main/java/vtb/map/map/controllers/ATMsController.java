package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.ATMsDto;
import vtb.map.map.services.ATMsService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/atm_s")
@CrossOrigin(origins = "http://localhost:3000")
public class ATMsController {
    private final ATMsService aTM_sService;

    @GetMapping("/getATM_s")
    public List<ATMsDto> getATM_s() {
        return aTM_sService.showAllATM_s();
    }

    @PostMapping("/getATM_sById")
    public ATMsDto showATM_sDto(@RequestParam long id) {
        return aTM_sService.showATM_sDto(id);
    }

    @PostMapping("/saveAllATM_s")
    public boolean saveATM_s(@RequestBody List<ATMsDto> dto) {
        return aTM_sService.addATM_sList(dto);
    }

    @PutMapping("/updateATM_s")
    public boolean updateATM_s(@RequestBody ATMsDto dto) {
        return aTM_sService.updateATM_s(dto);
    }

    @DeleteMapping("/deleteATM_sById")
    public boolean deleteATM_sById(@RequestParam long id) {
        return aTM_sService.deleteATM_sById(id);
    }

}
