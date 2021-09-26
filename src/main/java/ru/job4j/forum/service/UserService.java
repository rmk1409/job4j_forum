package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {
    private final Map<String, User> nameToUser = new ConcurrentHashMap<>();

    public UserService() {
        nameToUser.put("n1", User.of("n1", "p1"));
    }

    public Collection<User> getAll() {
        return nameToUser.values();
    }

    public User findByName(String name) {
        return nameToUser.get(name);
    }

    public boolean add(User user) {
        User obj = nameToUser.putIfAbsent(user.getName(), user);
        return Objects.nonNull(obj);
    }
}