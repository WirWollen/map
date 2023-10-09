package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.RoleEnum;
import vtb.map.map.services.RoleService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "http://localhost:3000")
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/getRoles")
    public List<RoleEnum> getStates() {
        return roleService.showAllRoles();
    }

    @DeleteMapping("/deleteRole")
    public boolean deleteRole(RoleEnum role) {
        return roleService.deleteRole(role);
    }

    @PutMapping("/renameRole")
    public boolean renameRole(RoleEnum to, RoleEnum before) {
        return roleService.renameRole(to, before);
    }

    @PostMapping("/addRole")
    public boolean renameRole(RoleEnum role) {
        return roleService.addRole(role);
    }

}
