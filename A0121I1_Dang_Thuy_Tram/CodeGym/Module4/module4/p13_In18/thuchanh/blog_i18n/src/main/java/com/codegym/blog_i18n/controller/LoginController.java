package com.codegym.blog_i18n.controller;

import com.codegym.blog_i18n.model.User;
import com.codegym.blog_i18n.model.UserLoginned;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {
    @ModelAttribute
    public User user() {
        return new User();
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        return "login";
    }

    @PostMapping("/login")
    public String dashboard(@ModelAttribute("user") User user) {
        UserLoginned userLoginned = new UserLoginned();
        userLoginned.setUsername(user.getUsername());
        return "redirect:/dashboard";
    }

}
