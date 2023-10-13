package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.DepartmentConverter;
import vtb.map.map.dtos.DepartmentDto;
import vtb.map.map.entities.DepartmentEntity;
import vtb.map.map.entities.LocalityEntity;
import vtb.map.map.repo.DepartmentRepo;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepo departmentRepo;
    private final WorkloadService workloadService;

    public List<DepartmentDto> showAllDepartments() {
        return departmentRepo.findAll().stream().map(DepartmentConverter::toDto).collect(Collectors.toList());
    }

    public DepartmentDto showDepartmentDto(long id) {
        return DepartmentConverter.toDto(departmentRepo.findById(id).get());
    }

    public boolean addDepartmentList(List<DepartmentDto> dtoList) {
        departmentRepo.saveAll(dtoList.stream().map(DepartmentConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateDepartment(DepartmentDto dto) {
        if (departmentRepo.existsById(dto.getId())) {
           departmentRepo.save(DepartmentConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteDepartmentById(long id) {
        departmentRepo.deleteById(id);
        return true;
    }

    public Map<Long, Integer> getWorkload(Long localityId) {
        return workloadService.getWorkload(localityId);
    }
}
