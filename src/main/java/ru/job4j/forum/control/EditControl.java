package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class EditControl {
    private final PostService posts;

    public EditControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping("/edit")
    public String getPage(HttpSession session, @RequestParam(required = false) Integer id, Model model) {
        if (Objects.isNull(session.getAttribute("authUser"))) {
            return "redirect:login";
        }

        if (Objects.nonNull(id)) {
            model.addAttribute("post", posts.findById(id));
        }

        return "edit";
    }

    @PostMapping("/edit")
    public String saveOrUpdate(@ModelAttribute Post post) {
        posts.save(post);
        return "redirect:index";
    }
}
