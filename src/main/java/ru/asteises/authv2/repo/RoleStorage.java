package ru.asteises.authv2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.asteises.authv2.model.entity.Role;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleStorage extends JpaRepository<Role, UUID> {

    Optional<Role> getRoleById(UUID id);
    Optional<Role> getRoleByName(String name);
}
