package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.StateDto;
import vtb.map.map.enums.SearchFilter;
import vtb.map.map.services.StateService;

import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/state")
@CrossOrigin(origins = "http://localhost:3000")
public class StateController {
    private final StateService stateService;
    @GetMapping("/getStates")
    public List<StateDto> getStates() {
        return stateService.showAllStates();
    }

    @PostMapping("/getStateById")
    public StateDto showStateDto(@RequestParam long id) {
        return stateService.showStateDto(id);
    }
    @PostMapping("/saveAllStates")
    public boolean saveState(@RequestBody List<StateDto> dto) {
        return stateService.addStateList(dto);
    }

    @PutMapping("/updateState")
    public boolean updateState(@RequestBody StateDto dto) {
        return stateService.updateState(dto);
    }

    @DeleteMapping("/deleteStateById")
    public boolean deleteStateById(@RequestParam long id) {
        return stateService.deleteStateById(id);
    }

    @GetMapping("/findAllNamesOnly")
    public Map<Long, String> findAllStateNamesOnly() {
        return stateService.findAllStateNamesOnly();
    }

    @GetMapping("/findByName")
    public Set<Long> findStateByName(SearchFilter filter, String name) {
        return stateService.findByName(filter, name);
    }
}
