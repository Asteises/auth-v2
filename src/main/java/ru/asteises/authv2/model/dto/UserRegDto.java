package ru.asteises.authv2.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRegDto {

    private String username;
    private String email;
}
