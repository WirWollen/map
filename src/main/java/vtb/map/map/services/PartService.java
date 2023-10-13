package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.PartConverter;
import vtb.map.map.dtos.PartDto;
import vtb.map.map.repo.PartRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PartService {
    private final PartRepo partRepo;

    public List<PartDto> showAllPart(){
        return partRepo.findAll().stream().map(PartConverter::toDto).collect(Collectors.toList());
    }

    public PartDto showPartDto(long id){return PartConverter.toDto(partRepo.findById(id).get());}

    public boolean addPartList(List<PartDto> dtoList){
        partRepo.saveAll(dtoList.stream().map(PartConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updatePart(PartDto dto) {
        if (partRepo.existsById(dto.getId())) {
            partRepo.save(PartConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deletePartById(long id) {
        partRepo.deleteById(id);
        return true;
    }
}
