package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.LocalityConverter;
import vtb.map.map.dtos.LocalityDto;
import vtb.map.map.entities.LocalityEntity;
import vtb.map.map.enums.SearchFilter;
import vtb.map.map.repo.LocalityRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

    public Map<Long, String> findAllLocalityNamesOnly() {
        return localityRepo.findAllLocalityNamesOnly().stream().collect(Collectors.toMap(LocalityEntity::getId, LocalityEntity::getName, (a, b) -> b, HashMap::new));
    }

    public Set<Long> findByName(SearchFilter searchFilter, String name) {
        switch (searchFilter) {
            case EQUAL -> {
                return localityRepo.findEqual(name).stream().map(el -> el.getId()).collect(Collectors.toSet());
            }
            case NOT_EQUAL -> {
                return localityRepo.findNotEqual(name).stream().map(el -> el.getId()).collect(Collectors.toSet());
            }
            case CONTAINS -> {
                return localityRepo.findContains(name).stream().map(el -> el.getId()).collect(Collectors.toSet());
            }
            case NOT_CONTAINS -> {
                return localityRepo.findNotContains(name).stream().map(el -> el.getId()).collect(Collectors.toSet());
            }
            default -> throw new RuntimeException();
        }
    }

    public LocalityDto findByName(String name) {
        return LocalityConverter.toDto(localityRepo.findEqualLocality(name));
    }
}
