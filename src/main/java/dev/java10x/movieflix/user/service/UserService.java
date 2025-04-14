package dev.java10x.movieflix.user.service;

import dev.java10x.movieflix.user.model.User;
import dev.java10x.movieflix.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User user){
        return repository.save(user);
    }
}
