package com.codegym.countview.controller;


import com.codegym.countview.model.MyCount;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("mycounter")
public class MyCountController {

    @ModelAttribute("mycounter")
    public MyCount myCount(){
        return new MyCount();
    }


    @GetMapping("/")
    public String getView(@ModelAttribute("mycounter") MyCount myCount){
        myCount.increment();
        return "index";
    }
}
