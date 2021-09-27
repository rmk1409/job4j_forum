package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

@Controller
public class RegControl {
    private final UserService userService;

    public RegControl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/reg")
    public String getPage() {
        return "reg";
    }

    @PostMapping("/reg")
    public String reg(@ModelAttribute User user, Model model) {
        if (!userService.add(user)) {
            model.addAttribute("errorMessage", "Try to use another name");
            return "reg";
        }

        return "redirect:login";
    }
}
