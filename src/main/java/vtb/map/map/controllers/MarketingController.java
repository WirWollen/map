package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.MarketingDto;
import vtb.map.map.services.MarketingService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/marketing")
@CrossOrigin(origins = "http://localhost:3000")
public class MarketingController {
    private final MarketingService marketingService;
    @GetMapping("/getMarketing")
    public List<MarketingDto> getMarketing() {return marketingService.showAllMarketing();}

    @PostMapping("/getMarketingById")
    public MarketingDto showMarketingDto(@RequestParam long id) {
        return marketingService.showMarketingDto(id);
    }
    @PostMapping("/saveAllMarketing")
    public boolean saveMarketing(@RequestBody List<MarketingDto> dto) {
        return marketingService.addMarketingList(dto);
    }

    @PutMapping("/updateMarketing")
    public boolean updateMarketing(@RequestBody MarketingDto dto) {
        return marketingService.updateMarketing(dto);
    }

    @DeleteMapping("/deleteMarketingById")
    public boolean deleteMarketingById(@RequestParam long id) {
        return marketingService.deleteMarketingById(id);
    }
}
