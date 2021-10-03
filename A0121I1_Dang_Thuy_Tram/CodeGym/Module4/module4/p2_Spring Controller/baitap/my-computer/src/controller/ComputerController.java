package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComputerController {
    @GetMapping("/")
    public String getViewComputer() {
        return "index";
    }

    @GetMapping("/answer")
    public String getanswer(@RequestParam("action") String action, @RequestParam("a") double a, @RequestParam("b") double b, Model model) {
        double result = 0;
        switch (action) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    result = 0;
                    break;
                } else {
                    result = a / b;
                    break;
                }
        }
        if (result == 0) {
            model.addAttribute("Result", "disivion invail b!=0");
        } else {
            model.addAttribute("Result", "Result : " + result);
        }
        model.addAttribute("a", a);
        model.addAttribute("b", b);

        return "index";
    }
}
