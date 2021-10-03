package codegym.controller;


import codegym.entity.Customer;
import codegym.entity.Province;
import codegym.repository.CustomerRepository;
import codegym.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;


@Controller
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProvinceRepository provinceRepository;
    @GetMapping("/index")
    public String showCus(Model model){
        model.addAttribute("customers",customerRepository.findAll());
        return "customer/index";
    }
    @GetMapping("/create")
    public String showCusCreate(Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("action","Create");
        model.addAttribute("provinces",provinceRepository.findAll());
        return "customer/create";
    }
    @PostMapping("/create")
    public String cusCreate(Model model, @ModelAttribute Customer customer){
        customerRepository.save(customer);
        return "redirect:/index";
    }
    @GetMapping("/edit/{id}")
    public String showCusEdit(@PathVariable("id") int id,Model model){
        model.addAttribute("customer",customerRepository.findById(id));
        model.addAttribute("action","update");
        model.addAttribute("provinces",provinceRepository.findAll());
        return "customer/create";
    }
    @GetMapping("/delete/{id}")
    public String showCusDel(@PathVariable("id") int id,Model model){
        customerRepository.deleteById(id);
        return "redirect:/index";

    }
    @GetMapping("/province")
    public String showProvince(Model model){
model.addAttribute("provinces",provinceRepository.findAll());
        return "provinces/index";

    }
    @GetMapping("/province/create")
    public String showProCreate(Model model){
        model.addAttribute("province",new Province());
        model.addAttribute("action","Create");
        return "provinces/create";
    }
    @PostMapping("/province/create")
    public String provinceCreate(Model model, @ModelAttribute Province province){
        provinceRepository.save(province);
        return "redirect:/province";
    }
    @GetMapping("/province/edit/{id}")
    public String showProEdit(@PathVariable("id") int id,Model model){
        model.addAttribute("province",provinceRepository.findById(id));
        model.addAttribute("action","update");
        return "provinces/create";
    }
    @GetMapping("/province/delete/{id}")
    public String showProdel(@PathVariable("id") int id,Model model){
        provinceRepository.deleteById(id);
        return "redirect:/province";

    }
}
