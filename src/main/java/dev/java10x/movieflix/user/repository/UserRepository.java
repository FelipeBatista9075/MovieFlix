package dev.java10x.movieflix.user.repository;

import dev.java10x.movieflix.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
