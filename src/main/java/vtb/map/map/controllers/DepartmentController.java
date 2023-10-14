package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.DepartmentDto;
import vtb.map.map.enums.Individual;
import vtb.map.map.exceptions.TheSpecifiedDateIsNotPossibleException;
import vtb.map.map.services.DepartmentService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/department")
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/getDepartment")
    public List<DepartmentDto> getDepartment() {
        return departmentService.showAllDepartments();
    }

    @PostMapping("/getDepartmentById")
    public DepartmentDto showDepartmentDto(@RequestParam long id) {
        return departmentService.showDepartmentDto(id);
    }

    @PostMapping("/saveAllDepartments")
    public boolean saveDepartment(@RequestBody List<DepartmentDto> dto) {
        return departmentService.addDepartmentList(dto);
    }

    @PutMapping("/updateDepartment")
    public boolean updateDepartment(@RequestBody DepartmentDto dto) {
        return departmentService.updateDepartment(dto);
    }

    @DeleteMapping("/deleteDepartmentById")
    public boolean deleteDepartmentById(@RequestParam long id) {
        return departmentService.deleteDepartmentById(id);
    }

    @GetMapping("/getWorkloadOfDepartment")
    public Map<Long, Integer> getWorkloadOfDepartment(long id) {
        return departmentService.getWorkload(id);
    }

    @GetMapping("/register")
    public String saveRegistration(Individual type, Long departmentId, Timestamp time) throws TheSpecifiedDateIsNotPossibleException {
        return departmentService.register(type, departmentId, time);
    }

    @GetMapping("/test")
    public Integer test(Long id) {
        return departmentService.calculateTimeInd(id);
    }
}
