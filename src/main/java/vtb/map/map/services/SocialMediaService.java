package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.SocialMediaConverter;
import vtb.map.map.dtos.SocialMediaDto;
import vtb.map.map.repo.SocialMediaRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SocialMediaService {
    private final SocialMediaRepo socialMediaRepo;

    public List<SocialMediaDto> showAllSocialMedia() {
        return socialMediaRepo.findAll().stream().map(SocialMediaConverter::toDto).collect(Collectors.toList());
    }

    public SocialMediaDto showSocialMediaDto(long id) {
        return SocialMediaConverter.toDto(socialMediaRepo.findById(id).get());
    }

    public boolean addSocialMediaList(List<SocialMediaDto> dtoList) {
        socialMediaRepo.saveAll(dtoList.stream().map(SocialMediaConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateSocialMedia(SocialMediaDto dto) {
        if (socialMediaRepo.existsById(dto.getId())) {
            socialMediaRepo.save(SocialMediaConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteSocialMediaById(long id) {
        socialMediaRepo.deleteById(id);
        return true;
    }
}
