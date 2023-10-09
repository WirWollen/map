package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.RoleConverter;
import vtb.map.map.dtos.RoleEnum;
import vtb.map.map.exceptions.IllegalRoleException;
import vtb.map.map.repo.RoleRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepo roleRepo;

    public List<RoleEnum> showAllRoles() {
        return roleRepo.findAll().stream().map(RoleConverter::toDto).collect(Collectors.toList());
    }

    @Transactional
    public boolean deleteRole(RoleEnum role) throws IllegalRoleException {
        if (!roleRepo.roleExists(role)) {
            throw new IllegalRoleException(String.format("Role %s does not exist.", role));
        }
        roleRepo.deleteByRole(role);
        return true;
    }

    @Transactional
    public boolean renameRole(RoleEnum to, RoleEnum before) throws IllegalRoleException {
        if (!roleRepo.roleExists(to)) {
            throw new IllegalRoleException(String.format("Role %s does not exist.", to));
        }
        if (!roleRepo.roleExists(before)) {
            throw new IllegalRoleException(String.format("Role %s does not exist.", before));
        }
        roleRepo.renameRole(to, before);
        return true;
    }

    @Transactional
    public boolean addRole(RoleEnum role) throws IllegalRoleException {
        if (!roleRepo.roleExists(role)) {
            throw new IllegalRoleException(String.format("Role %s does not exist", role));
        }
        roleRepo.save(RoleConverter.toEntity(role));
        return true;
    }


}
