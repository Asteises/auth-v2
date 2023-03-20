package ru.asteises.authv2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.asteises.authv2.model.entity.User;

import java.util.Optional;

@Repository
public interface UserStorage extends JpaRepository<User, Long> {

    Optional<User> getUserByEmail(String email);
}
