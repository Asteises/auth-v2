package ru.asteises.authv2.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "role_name")
    private String name;
}
