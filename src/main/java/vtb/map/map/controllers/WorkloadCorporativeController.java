package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.WorkloadCorporativeDto;
import vtb.map.map.services.WorkloadCorporativeService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/workloadcontroller")
@CrossOrigin(origins = "http://localhost:3000")
public class WorkloadCorporativeController {
    private final WorkloadCorporativeService workloadCorporativeService;
    @GetMapping("/getWorkloadCorporative")
    public List<WorkloadCorporativeDto> getWorkload() {return workloadCorporativeService.showAllWorkloadCorporative();}

    @PostMapping("/getWorkloadCorporativeById")
    public WorkloadCorporativeDto showWorkloadCorporativeDto(@RequestParam long id) {
        return workloadCorporativeService.showWorkloadCorporativeDto(id);
    }
    @PostMapping("/saveAllWorkloadCorporative")
    public boolean saveWorkloadCorporative(@RequestBody List<WorkloadCorporativeDto> dto) {
        return workloadCorporativeService.addWorkloadCorporativeList(dto);
    }

    @PutMapping("/updateWorkloadCorporative")
    public boolean updateWorkloadCorporative(@RequestBody WorkloadCorporativeDto dto) {
        return workloadCorporativeService.updateWorkloadCorporative(dto);
    }

    @DeleteMapping("/deleteWorkloadCorporativeById")
    public boolean deleteWorkloadCorporativeById(@RequestParam long id) {
        return workloadCorporativeService.deleteWorkloadCorporativeById(id);
    }
}
