package ru.asteises.authservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.asteises.authservice.mapper.RoleMapper;
import ru.asteises.authservice.model.entity.Role;
import ru.asteises.authservice.model.dto.RoleDto;
import ru.asteises.authservice.model.dto.RoleRegDto;
import ru.asteises.authservice.repo.RoleStorage;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleStorage roleStorage;

    /**
     * id генерируется в маппере.
     */
    public RoleDto add(RoleRegDto roleRegDto) {
        Role newRole = RoleMapper.INSTANCE.map(roleRegDto);
        roleStorage.save(newRole);
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
        return roleStorage.getRoleByName("USER")
                .orElseThrow(() -> new RoleNotFoundException("Role not found"));
    }

    public List<RoleDto> getAll() {
        return RoleMapper.INSTANCE.map(roleStorage.findAll());
    }

}
