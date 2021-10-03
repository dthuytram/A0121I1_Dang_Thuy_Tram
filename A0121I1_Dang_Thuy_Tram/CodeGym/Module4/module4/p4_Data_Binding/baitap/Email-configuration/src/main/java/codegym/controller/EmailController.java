package codegym.controller;

import codegym.bean.Email;
import codegym.service.ServiceEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {
    @Autowired
    ServiceEmail serviceEmail;
    @GetMapping("/")
    public String showFrom(Model model) {
        model.addAttribute("emails",serviceEmail.list());
        return "index";
    }
    @GetMapping("/create")
    public String showFromcreate(Model model){
        model.addAttribute("arrayLanguage",getlanguage());
        model.addAttribute("arraynumber",getnumber());
        Email email = new Email();
        int id = serviceEmail.list().size()+1;
        System.out.println(id);
        model.addAttribute("idFinal",id);
        email.setId(id);
        model.addAttribute("email",email);
        model.addAttribute("action","create");

        return "update";
    }
    @PostMapping("/create")
    public String saveoredit(@ModelAttribute Email email, Model model){
        model.addAttribute("arrayLanguage",getlanguage());
        model.addAttribute("arraynumber",getnumber());

        serviceEmail.saveOrEdit(email);
        for(Email email1 :serviceEmail.list()){
        System.out.println(email1.getId());
}
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("arrayLanguage",getlanguage());
        model.addAttribute("arraynumber",getnumber());
        Email email = serviceEmail.getbyId(id);
        model.addAttribute("email",email);
        model.addAttribute("action","edit");
        return "update";
    }
    List<String> getlanguage(){
        List<String> array = new ArrayList<>();
        array.add("English");
        array.add("Vietnamese");
        array.add("Japanese");
        array.add("Chinese");
        return array;
    }
    List<Integer> getnumber(){
        List<Integer> array = new ArrayList<>();
        array.add(5);
        array.add(10);
        array.add(15);
        array.add(25);
        array.add(50);
        array.add(100);
        return array;
    }
}
