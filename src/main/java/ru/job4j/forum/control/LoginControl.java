package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class LoginControl {
    private final UserService userService;

    public LoginControl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model, HttpSession session) {
        User foundUser = userService.findByName(user.getName());
        if (Objects.isNull(foundUser) || !Objects.equals(foundUser.getPassword(), user.getPassword())) {
            model.addAttribute("errorMessage", "Username or Password is incorrect !!");
            return "login";
        }

        session.setAttribute("authUser", user);
        return "redirect:index";
    }
}
