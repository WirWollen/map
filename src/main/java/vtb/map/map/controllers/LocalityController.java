package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.LocalityDto;
import vtb.map.map.enums.SearchFilter;
import vtb.map.map.services.LocalityService;

import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/locality")
@CrossOrigin(origins = "http://localhost:3000")
public class LocalityController {
    private final LocalityService localityService;

    @GetMapping("/getLocalities")
    public List<LocalityDto> getLocalities() {
        return localityService.showAllLocalities();
    }

    @PostMapping("/getLocalityById")
    public LocalityDto showLocalityDto(@RequestParam long id) {
        return localityService.showLocalityDto(id);
    }

    @PostMapping("/saveAllLocalities")
    public boolean saveLocality(@RequestBody List<LocalityDto> dto) {
        return localityService.addLocalityList(dto);
    }

    @PutMapping("/updateLocality")
    public boolean updateLocality(@RequestBody LocalityDto dto) {
        return localityService.updateLocality(dto);
    }

    @DeleteMapping("/deleteLocalityById")
    public boolean deleteLocalityById(@RequestParam long id) {
        return localityService.deleteLocalityById(id);
    }

    @GetMapping("/findAllNamesOnly")
    public Map<Long, String> findAllLocalityNamesOnly() {
        return localityService.findAllLocalityNamesOnly();
    }

    @GetMapping("/findByName")
    public Set<Long> findByName(SearchFilter filter, String name) {
        return localityService.findByName(filter, name);
    }

    @GetMapping("/findLocalityByName")
    public LocalityDto findLocalityByName(String name) {
        return localityService.findByName(name);
    }
}
