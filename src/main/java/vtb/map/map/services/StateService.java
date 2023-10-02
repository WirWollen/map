package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.StateConverter;
import vtb.map.map.dtos.StateDto;
import vtb.map.map.repo.StateRepo;

import java.util.List;
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
}
