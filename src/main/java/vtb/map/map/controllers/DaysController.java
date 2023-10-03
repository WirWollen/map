package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.DayDto;
import vtb.map.map.services.DaysService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/days")
public class DaysController {
    private final DaysService daysService;
    @GetMapping("/getDays")
    public List<DayDto> getDays() {return daysService.showAllDays();}

    @PostMapping("/getDaysById")
    public DayDto showDaysDto(@RequestParam long id) {
        return daysService.showDaysDto(id);
    }
    @PostMapping("/saveAllDays")
    public boolean saveDays(@RequestBody List<DayDto> dto) {
        return daysService.addDaysList(dto);
    }

    @PutMapping("/updateDays")
    public boolean updateDays(@RequestBody DayDto dto) {
        return daysService.updateDays(dto);
    }

    @DeleteMapping("/deleteDaysById")
    public boolean deleteDaysById(@RequestParam long id) {
        return daysService.deleteDaysById(id);
    }
}