package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.DepartmentDto;
import vtb.map.map.services.DepartmentService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    @GetMapping("/getDepartment")
    public List<DepartmentDto> getDepartment() {return departmentService.showAllDepartments();}

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
}
