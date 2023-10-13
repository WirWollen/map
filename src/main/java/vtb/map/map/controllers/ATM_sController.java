package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.ATMs_Dto;
import vtb.map.map.services.ATMs_Service;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/atm_s")
@CrossOrigin(origins = "http://localhost:3000")
public class ATM_sController {
    private final ATMs_Service aTM_sService;

    @GetMapping("/getATM_s")
    public List<ATMs_Dto> getATM_s() {
        return aTM_sService.showAllATM_s();
    }

    @PostMapping("/getATM_sById")
    public ATMs_Dto showATM_sDto(@RequestParam long id) {
        return aTM_sService.showATM_sDto(id);
    }

    @PostMapping("/saveAllATM_s")
    public boolean saveATM_s(@RequestBody List<ATMs_Dto> dto) {
        return aTM_sService.addATM_sList(dto);
    }

    @PutMapping("/updateATM_s")
    public boolean updateATM_s(@RequestBody ATMs_Dto dto) {
        return aTM_sService.updateATM_s(dto);
    }

    @DeleteMapping("/deleteATM_sById")
    public boolean deleteATM_sById(@RequestParam long id) {
        return aTM_sService.deleteATM_sById(id);
    }

}
