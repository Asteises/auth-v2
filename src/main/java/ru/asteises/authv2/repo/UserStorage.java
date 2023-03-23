package ru.asteises.authv2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.asteises.authv2.model.entity.User;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserStorage extends JpaRepository<User, UUID> {

    Optional<User> getUserByEmail(String email);
}
