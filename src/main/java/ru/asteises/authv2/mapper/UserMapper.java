package ru.asteises.authv2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.asteises.authv2.model.dto.UserDto;
import ru.asteises.authv2.model.dto.UserRegDto;
import ru.asteises.authv2.model.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User map(UserRegDto userRegDto);

    UserDto map(User user);

    List<UserDto> map(List<User> users);

}
