package ru.job4j.forum.model;

import java.util.Calendar;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Post {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);
    private int id;
    private String name;
    private String desc;
    private Calendar created = Calendar.getInstance();

    public static Post of(String name, String desc) {
        Post post = new Post();
        post.id = Post.ID_GENERATOR.incrementAndGet();
        post.name = name;
        post.desc = desc;
        return post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id
                && Objects.equals(name, post.name)
                && Objects.equals(desc, post.desc)
                && Objects.equals(created, post.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, created);
    }

    @Override
    public String toString() {
        return "Post{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", desc='" + desc + '\''
                + ", created=" + created.getTime()
                + '}';
    }
}