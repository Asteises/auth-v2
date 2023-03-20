package ru.asteises.authv2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.asteises.authv2.mapper.UserMapper;
import ru.asteises.authv2.model.dto.UserDto;
import ru.asteises.authv2.model.dto.UserRegDto;
import ru.asteises.authv2.model.entity.User;
import ru.asteises.authv2.repo.UserStorage;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserStorage userStorage;

    public UserDto registration(UserRegDto userRegDto) {
        User user = UserMapper.INSTANCE.map(userRegDto);
        user = userStorage.save(user);
        return UserMapper.INSTANCE.map(user);
    }

    public UserDto getUserBy(Long userId) {
        User user = userStorage.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.INSTANCE.map(user);
    }

    public UserDto getUserBy(String email) {
        User user = userStorage.getUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.INSTANCE.map(user);
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userStorage.findAll();
        return UserMapper.INSTANCE.map(users);
    }
}