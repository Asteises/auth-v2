package ru.asteises.authservice.mapper;

import org.mapstruct.Context;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.asteises.authservice.model.dto.UserDto;
import ru.asteises.authservice.model.dto.UserRegDto;
import ru.asteises.authservice.model.entity.User;
import ru.asteises.authservice.service.RoleService;

import javax.management.relation.RoleNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        imports = {UUID.class, Collections.class},
        uses = {RoleService.class})
public interface UserMapper {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(8);

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "roles", expression = "java(Collections.singletonList(roleService.getRoleUser()))")
    @Mapping(target = "password", expression = "java(encoder.encode(userRegDto.getPassword()))")
    User map(UserRegDto userRegDto, @Context RoleService roleService) throws RoleNotFoundException;

    @Mapping(target = "username", source = "name")
    UserDto map(User user);

    List<UserDto> map(List<User> users);

}
