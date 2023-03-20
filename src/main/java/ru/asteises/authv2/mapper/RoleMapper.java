package ru.asteises.authv2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.asteises.authv2.model.dto.RoleDto;
import ru.asteises.authv2.model.dto.RoleRegDto;
import ru.asteises.authv2.model.entity.Role;

import java.util.List;

@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role map(RoleRegDto roleRegDto);

    RoleDto map(Role role);

    List<RoleDto> map(List<Role> roles);
}
