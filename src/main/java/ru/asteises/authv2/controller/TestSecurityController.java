package ru.asteises.authv2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestSecurityController {

    @GetMapping("/current_time")
    public String getCurrentTime() {
        return String.valueOf(System.currentTimeMillis());
    }
}
