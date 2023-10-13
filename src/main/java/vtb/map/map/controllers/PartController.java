package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.PartDto;
import vtb.map.map.services.PartService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/days")
@CrossOrigin(origins = "http://localhost:3000")
public class PartController {
    private final PartService partService;
    @GetMapping("/getPart")
    public List<PartDto> getPart() {return partService.showAllPart();}

    @PostMapping("/getPartById")
    public PartDto showPartDto(@RequestParam long id) {
        return partService.showPartDto(id);
    }
    @PostMapping("/saveAllPart")
    public boolean savePart(@RequestBody List<PartDto> dto) {
        return partService.addPartList(dto);
    }

    @PutMapping("/updatePart")
    public boolean updatePart(@RequestBody PartDto dto) {
        return partService.updatePart(dto);
    }

    @DeleteMapping("/deletePartById")
    public boolean deletePartById(@RequestParam long id) {
        return partService.deletePartById(id);
    }
}
