package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.WorkDaysDto;
import vtb.map.map.services.WorkDaysService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/workDays")
@CrossOrigin(origins = "http://localhost:3000")
public class WorkDaysController {
    private final WorkDaysService workDaysService;
    @GetMapping("/getWorkDays")
    public List<WorkDaysDto> getWorkDays() {return workDaysService.showAllWorkDays();}

    @PostMapping("/getWorkDaysById")
    public WorkDaysDto showWorkDaysDto(@RequestParam long id) {
        return workDaysService.showWorkDaysDto(id);
    }
    @PostMapping("/saveAllWorkDays")
    public boolean saveWorkDays(@RequestBody List<WorkDaysDto> dto) {
        return workDaysService.addWorkDaysList(dto);
    }

    @PutMapping("/updateWorkDays")
    public boolean updateWorkDays(@RequestBody WorkDaysDto dto) {
        return workDaysService.updateWorkDays(dto);
    }

    @DeleteMapping("/deleteWorkDaysById")
    public boolean deleteWorkDaysById(@RequestParam long id) {
        return workDaysService.deleteWorkDaysById(id);
    }

    @PostMapping("/addWorkDays")
    public Long addWorkDays(@RequestBody WorkDaysDto dto) {
        return workDaysService.addWorkDay(dto);
    }
}
