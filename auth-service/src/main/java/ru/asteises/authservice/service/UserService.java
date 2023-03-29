package ru.asteises.authservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.asteises.authservice.mapper.UserMapper;
import ru.asteises.authservice.model.dto.UserDto;
import ru.asteises.authservice.model.dto.UserRegDto;
import ru.asteises.authservice.model.entity.User;
import ru.asteises.authservice.repo.UserStorage;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserStorage userStorage;
    private final RoleService roleService;

    /**
     * id генерируется в маппере.
     */
    public UserDto registration(UserRegDto userRegDto) throws RoleNotFoundException {
        User user = UserMapper.INSTANCE.map(userRegDto, roleService);
        userStorage.save(user);
        return UserMapper.INSTANCE.map(user);
    }

    public User getUserForSecurity(String email) {
        return userStorage.getUserByEmail(email).orElseThrow();
    }

    public UserDto getUserBy(UUID userId) {
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
