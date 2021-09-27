package ru.job4j.forum.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.store.UserRepository;

@Service
public class UserService {
    private final UserRepository users;

    public UserService(UserRepository users) {
        this.users = users;
    }

    public User findByName(String name) {
        return users.findByName(name);
    }

    public boolean add(User user) {
        try {
            users.save(user);
        } catch (DataIntegrityViolationException e) {
            return false;
        }
        return true;
    }
}
