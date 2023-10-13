package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.WorkloadDto;
import vtb.map.map.services.WorkloadService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/workload")
@CrossOrigin(origins = "http://localhost:3000")
public class WorkloadController {
    private final WorkloadService workloadService;
    @GetMapping("/getWorkload")
    public List<WorkloadDto> getWorkload() {return workloadService.showAllWorkload();}

    @PostMapping("/getWorkloadById")
    public WorkloadDto showWorkloadDto(@RequestParam long id) {
        return workloadService.showWorkloadDto(id);
    }
    @PostMapping("/saveAllWorkload")
    public boolean saveWorkload(@RequestBody List<WorkloadDto> dto) {
        return workloadService.addWorkloadList(dto);
    }

    @PutMapping("/updateWorkload")
    public boolean updateWorkload(@RequestBody WorkloadDto dto) {
        return workloadService.updateWorkload(dto);
    }

    @DeleteMapping("/deleteWorkloadById")
    public boolean deleteWorkloadById(@RequestParam long id) {
        return workloadService.deleteWorkloadById(id);
    }
}
