package ru.asteises.authv2.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.asteises.authv2.model.dto.RoleDto;
import ru.asteises.authv2.model.dto.RoleRegDto;
import ru.asteises.authv2.model.entity.Role;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        imports = {UUID.class})
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    Role map(RoleRegDto roleRegDto);

    RoleDto map(Role role);

    List<RoleDto> map(List<Role> roles);
}
