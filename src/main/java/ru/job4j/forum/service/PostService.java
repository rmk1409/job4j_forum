package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PostService {
    private final Map<Integer, Post> idToPost = new ConcurrentHashMap<>();

    public PostService() {
        Post post = Post.of("Продаю машину ладу 01.", "desc1");
        idToPost.put(post.getId(), post);
    }

    public Collection<Post> getAll() {
        return idToPost.values();
    }

    public Post findById(int id) {
        return idToPost.get(id);
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post = Post.of(post.getName(), post.getDesc());
        }

        idToPost.put(post.getId(), post);
    }
}