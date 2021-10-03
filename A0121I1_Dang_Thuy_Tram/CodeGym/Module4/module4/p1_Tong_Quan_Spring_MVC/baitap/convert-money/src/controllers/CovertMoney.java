package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CovertMoney {
    @GetMapping("/covert")
    public String covert(){


        return "index";
    }
    @PostMapping("/covert")
    public String covert1(int usa, double rate, Model model){
    double kq= usa*rate;
    model.addAttribute("kq",kq);
    model.addAttribute("usa",usa);
    model.addAttribute("rate",rate);
        return "index";
    }
}
