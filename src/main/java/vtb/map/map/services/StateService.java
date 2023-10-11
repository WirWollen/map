package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.StateConverter;
import vtb.map.map.dtos.StateDto;
import vtb.map.map.entities.CountryEntity;
import vtb.map.map.entities.StateEntity;
import vtb.map.map.enums.SearchFilter;
import vtb.map.map.repo.StateRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StateService {
    private final StateRepo stateRepo;

    public List<StateDto> showAllStates() {
        return stateRepo.findAll().stream().map(StateConverter::toDto).collect(Collectors.toList());
    }

    public StateDto showStateDto(long id) {
        return StateConverter.toDto(stateRepo.findById(id).get());
    }

    public boolean addStateList(List<StateDto> dtoList) {
        stateRepo.saveAll(dtoList.stream().map(StateConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateState(StateDto dto) {
        if (stateRepo.existsById(dto.getId())) {
            stateRepo.save(StateConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteStateById(long id) {
        stateRepo.deleteById(id);
        return true;
    }

    public Map<Long, String> findAllStateNamesOnly() {
        return stateRepo.findAllStateNamesOnly().stream().collect(Collectors.toMap(StateEntity::getId, StateEntity::getName, (a, b) -> b, HashMap::new));
    }

    public Set<Long> findByName(SearchFilter searchFilter, String name) {
        switch (searchFilter) {
            case EQUAL -> {
                return stateRepo.findEqual(name).stream().map(el -> el.getId()).collect(Collectors.toSet());
            }
            case NOT_EQUAL -> {
                return stateRepo.findNotEqual(name).stream().map(el -> el.getId()).collect(Collectors.toSet());
            }
            case CONTAINS -> {
                return stateRepo.findContains(name).stream().map(el -> el.getId()).collect(Collectors.toSet());
            }
            case NOT_CONTAINS -> {
                return stateRepo.findNotContains(name).stream().map(el -> el.getId()).collect(Collectors.toSet());
            }
            default -> throw new RuntimeException();
        }
    }
}
