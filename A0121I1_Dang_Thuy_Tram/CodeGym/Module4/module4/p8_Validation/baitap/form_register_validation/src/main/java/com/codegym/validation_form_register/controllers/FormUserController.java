package com.codegym.validation_form_register.controllers;


import com.codegym.validation_form_register.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class FormUserController {

    @GetMapping("/register")
    public String getFormRegister(Model model){
        model.addAttribute("user", new User());
        return "register";
    }


    @PostMapping("/register")
    public String postFormRegister(@Valid @ModelAttribute User user, BindingResult bindingResult,Model  model){
        if (bindingResult.hasErrors()){
            return "register";
        }else{
            model.addAttribute("massage",user);
            return "result";
        }
    }
}
