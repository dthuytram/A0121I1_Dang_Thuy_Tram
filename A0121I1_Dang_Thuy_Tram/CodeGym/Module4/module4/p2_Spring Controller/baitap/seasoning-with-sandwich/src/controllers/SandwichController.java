package controllers;

import com.sun.deploy.net.MessageHeader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class SandwichController {
    List<String> stringList = Arrays.asList("sugar", "salt");
    @GetMapping("/")
    public String getView(Model model) {
        model.addAttribute("list", stringList);
        return "index";
    }


    @RequestMapping("/save")
    public String save(@RequestParam(value = "condiment" ,defaultValue = "not condiment") String[] condiment,Model model) {

model.addAttribute("condiment",condiment);
        return "list";
    }


}
