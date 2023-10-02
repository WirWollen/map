package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.LocalityDto;
import vtb.map.map.services.LocalityService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/locality")
public class LocalityController {
    private final LocalityService localityService;
    @GetMapping("/getLocalities")
    public List<LocalityDto> getLocalities() {return localityService.showAllLocalities();}

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
}
