package ru.asteises.authv2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.asteises.authv2.model.entity.Role;

import java.util.Optional;

@Repository
public interface RoleStorage extends JpaRepository<Role, Long> {

    Optional<Role> getRoleById(Long id);
}
