package com.codegym.cookie.controller;

import com.codegym.cookie.model.User;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class UserController {

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping("/login")
    public String indexLogin(@CookieValue(name = "setUser", defaultValue = "") String setUser, Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        return "login";
    }

    @PostMapping("/dologin")
    public String doLogin(@ModelAttribute User user, Model model, @CookieValue(name = "setUser", defaultValue = "") String setUser, HttpServletResponse response,
                          HttpServletRequest request) {
        if ("admin@gmail.com".equals(user.getEmail()) && "12345".equals(user.getPassword())) {

            setUser = user.getEmail();

            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(60 * 60);
            Cookie[] cookies = request.getCookies();
            for (Cookie ck : cookies) {
                if (ck.getName().equals("setUser")) {
                    model.addAttribute("cookieValue", ck);
                    break;
                } else {
                    ck.setValue("");
                    model.addAttribute("cookieValue", ck);
                }
            }
            response.addCookie(cookie);
            model.addAttribute("massage", "Login success. Welcome");
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            response.addCookie(cookie);
            model.addAttribute("messages", "Login failed. Try again");
        }
        return "login";
    }
}
