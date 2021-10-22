package com.codegym.blog_i18n.controller;

import com.codegym.blog_i18n.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class DashboardController {

    @GetMapping("/dashboard")
    public String login() {
        return "dashboard";
    }
}
