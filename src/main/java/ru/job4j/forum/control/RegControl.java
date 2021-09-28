package ru.job4j.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;
import ru.job4j.forum.store.AuthorityRepository;

@Controller
public class RegControl {
    private final UserService userService;
    private final PasswordEncoder encoder;
    private final AuthorityRepository authorities;

    public RegControl(UserService userService, PasswordEncoder encoder, AuthorityRepository authorities) {
        this.userService = userService;
        this.encoder = encoder;
        this.authorities = authorities;
    }

    @GetMapping("/reg")
    public String getPage() {
        return "reg";
    }

    @PostMapping("/reg")
    public String reg(@ModelAttribute User user, Model model) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorities.findByAuthority("ROLE_USER"));
        user.setEnabled(true);
        if (!userService.add(user)) {
            model.addAttribute("errorMessage", "Try to use another name");
            return "reg";
        }

        return "redirect:login";
    }
}
