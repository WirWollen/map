package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.AvailabilityDto;
import vtb.map.map.services.AvailabilityService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/availability")
@CrossOrigin(origins = "http://localhost:3000")
public class AvailabilityController{
    private final AvailabilityService availabilityService;
    @GetMapping("/getAvailability")
    public List<AvailabilityDto> getAvailability() {return availabilityService.showAllAvailability();}

    @PostMapping("/getAvailabilityById")
    public AvailabilityDto showAvailabilityDto(@RequestParam long id) {
        return availabilityService.showAvailabilityDto(id);
    }
    @PostMapping("/saveAllAvailability")
    public boolean saveAvailability(@RequestBody List<AvailabilityDto> dto) {
        return availabilityService.addAvailabilityList(dto);
    }

    @PutMapping("/updateAvailability")
    public boolean updateAvailability(@RequestBody AvailabilityDto dto) {
        return availabilityService.updateAvailability(dto);
    }

    @DeleteMapping("/deleteAvailabilityById")
    public boolean deleteAvailabilityById(@RequestParam long id) {
        return availabilityService.deleteAvailabilityById(id);
    }
}
