package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.LocalityConverter;
import vtb.map.map.dtos.LocalityDto;
import vtb.map.map.dtos.StateDto;
import vtb.map.map.repo.LocalityRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocalityService {
    private final LocalityRepo localityRepo;

    public List<LocalityDto> showAllLocalities() {
        return localityRepo.findAll().stream().map(LocalityConverter::toDto).collect(Collectors.toList());
    }

    public LocalityDto showLocalityDto(long id) {
        return LocalityConverter.toDto(localityRepo.findById(id).get());
    }

    public boolean addLocalityList(List<LocalityDto> dtoList) {
        localityRepo.saveAll(dtoList.stream().map(LocalityConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateLocality(LocalityDto dto) {
        if (localityRepo.existsById(dto.getId())) {
            localityRepo.save(LocalityConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteLocalityById(long id) {
        localityRepo.deleteById(id);
        return true;
    }
}
