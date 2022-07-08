package ru.neoflex.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.crud.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
