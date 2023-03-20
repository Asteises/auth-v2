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

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleStorage roleStorage;

    public RoleDto add(RoleRegDto roleRegDto) {
        Role newRole = RoleMapper.INSTANCE.map(roleRegDto);
        newRole = roleStorage.save(newRole);
        return RoleMapper.INSTANCE.map(newRole);
    }

    public RoleDto getById(Long roleId) throws RoleNotFoundException {
        Role role = roleStorage.getRoleById(roleId)
                .orElseThrow(() -> new RoleNotFoundException("Role not found"));
        return RoleMapper.INSTANCE.map(role);
    }

    public List<RoleDto> getAll() {
        return RoleMapper.INSTANCE.map(roleStorage.findAll());
    }
}
