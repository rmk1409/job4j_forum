package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutServlet {
    @GetMapping("/logout")
    public String doGet(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }
}