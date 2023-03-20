package ru.asteises.authv2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.asteises.authv2.model.dto.RoleDto;
import ru.asteises.authv2.model.dto.RoleRegDto;
import ru.asteises.authv2.service.RoleService;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/role")
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/add")
    public ResponseEntity<RoleDto> add(@RequestBody RoleRegDto roleRegDto) {
        return ResponseEntity.ok(roleService.add(roleRegDto));
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<RoleDto> getById(@PathVariable Long roleId) throws RoleNotFoundException {
        return ResponseEntity.ok(roleService.getById(roleId));
    }

    @GetMapping("/all")
    public List<RoleDto> getAll() {
        return roleService.getAll();
    }
}