package ru.asteises.authv2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.asteises.authv2.model.dto.UserDto;
import ru.asteises.authv2.model.dto.UserRegDto;
import ru.asteises.authv2.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<UserDto> registration(@RequestBody UserRegDto userRegDto) {
        return ResponseEntity.ok(userService.registration(userRegDto));
    }

    @GetMapping("/get_by_id/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
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
