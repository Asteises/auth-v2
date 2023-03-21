package ru.asteises.authv2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.asteises.authv2.mapper.RoleMapper;
import ru.asteises.authv2.model.dto.RoleDto;
import ru.asteises.authv2.model.dto.RoleRegDto;
import ru.asteises.authv2.model.entity.Role;
import ru.asteises.authv2.repo.RoleStorage;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleStorage roleStorage;

    public RoleDto add(RoleRegDto roleRegDto) {
        Role newRole = RoleMapper.INSTANCE.map(roleRegDto);
        newRole = roleStorage.save(newRole);
        return RoleMapper.INSTANCE.map(newRole);
    }

    public RoleDto getById(String roleId) throws RoleNotFoundException {
        Role role = roleStorage.getRoleById(UUID.fromString(roleId))
                .orElseThrow(() -> new RoleNotFoundException("Role not found"));
        return RoleMapper.INSTANCE.map(role);
    }

    public RoleDto getByName(String roleName) throws RoleNotFoundException {
        Role role = roleStorage.getRoleByName(roleName)
                .orElseThrow(() -> new RoleNotFoundException("Role not found"));
        return RoleMapper.INSTANCE.map(role);
    }

    public Role getRoleUser() throws RoleNotFoundException {
        return roleStorage.getRoleByName("ROLE_USER")
                .orElseThrow(() -> new RoleNotFoundException("Role not found"));
    }

    public List<RoleDto> getAll() {
        return RoleMapper.INSTANCE.map(roleStorage.findAll());
    }

}
