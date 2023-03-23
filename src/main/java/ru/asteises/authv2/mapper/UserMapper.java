package ru.asteises.authv2.mapper;

import org.mapstruct.Context;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.asteises.authv2.model.dto.UserDto;
import ru.asteises.authv2.model.dto.UserRegDto;
import ru.asteises.authv2.model.entity.User;
import ru.asteises.authv2.service.RoleService;

import javax.management.relation.RoleNotFoundException;
import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        imports = {Collections.class},
        uses = {RoleService.class})
public interface UserMapper {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(8);

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "roles", expression = "java(Collections.singletonList(roleService.getRoleUser()))")
    @Mapping(target = "password", expression = "java(encoder.encode(userRegDto.getPassword()))")
    User map(UserRegDto userRegDto, @Context RoleService roleService) throws RoleNotFoundException;

    UserDto map(User user);

    List<UserDto> map(List<User> users);

}
