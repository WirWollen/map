package vtb.map.map.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vtb.map.map.dtos.SocialMediaDto;
import vtb.map.map.services.SocialMediaService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/socialMedia")
@CrossOrigin(origins = "http://localhost:3000")
public class SocialMediaController {
    private final SocialMediaService socialMediaService;
    @GetMapping("/getSocialMedia")
    public List<SocialMediaDto> getSocialMedia() {return socialMediaService.showAllSocialMedia();}

    @PostMapping("/getSocialMediaById")
    public SocialMediaDto showSocialMediaDto(@RequestParam long id) {
        return socialMediaService.showSocialMediaDto(id);
    }
    @PostMapping("/saveAllSocialMedia")
    public boolean saveSocialMedia(@RequestBody List<SocialMediaDto> dto) {
        return socialMediaService.addSocialMediaList(dto);
    }

    @PutMapping("/updateSocialMedia")
    public boolean updateSocialMedia(@RequestBody SocialMediaDto dto) {
        return socialMediaService.updateSocialMedia(dto);
    }

    @DeleteMapping("/deleteSocialMediaById")
    public boolean deleteSocialMediaById(@RequestParam long id) {
        return socialMediaService.deleteSocialMediaById(id);
    }
}

