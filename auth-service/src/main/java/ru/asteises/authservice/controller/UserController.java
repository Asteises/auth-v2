package ru.asteises.authservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.asteises.authservice.service.UserService;
import ru.asteises.authservice.model.dto.UserDto;
import ru.asteises.authservice.model.dto.UserRegDto;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<UserDto> registration(@RequestBody UserRegDto userRegDto) throws RoleNotFoundException {
        return ResponseEntity.ok(userService.registration(userRegDto));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable UUID userId) {
        return ResponseEntity.ok(userService.getUserBy(userId));
    }

    @GetMapping("/")
    public ResponseEntity<UserDto> getUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userService.getUserBy(email));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
