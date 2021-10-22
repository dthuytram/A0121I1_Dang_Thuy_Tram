package com.codegym.casestudy_springboot.controller;

import com.codegym.casestudy_springboot.models.customer.Customer;
import com.codegym.casestudy_springboot.models.customer.CustomerType;
import com.codegym.casestudy_springboot.repositories.CustomerRepository;
import com.codegym.casestudy_springboot.repositories.CustomerTypeRepository;
import com.codegym.casestudy_springboot.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    CustomerTypeRepository customerTypeRepository;
    @GetMapping("/")
    public ModelAndView getList(@PageableDefault(size = 5) Pageable pageable,
                                @RequestParam(value = "search", defaultValue = "") String search,
                                Model model) {
        model.addAttribute("search", search);
        return new ModelAndView("customer/list", "customers", customerService.findByName(search, pageable));
    }

    @GetMapping("/{action}")
    public ModelAndView getFormAddCustomer(Model model,
                                           @PathVariable String action,
                                           @RequestParam(required = false, defaultValue = "") int id) {
        if (action.equals("create") && !model.containsAttribute("customer")) {
            model.addAttribute("customer", new Customer());
        } else if (action.equals("edit") && !model.containsAttribute("customer")) {
            model.addAttribute("customer", customerService.findById(id));
        }
        model.addAttribute("customerTypes", customerTypeRepository.findAll());
        model.addAttribute("genders", Arrays.asList("Male", "Female", "Others"));
        return new ModelAndView("customer/form");
    }

    @PostMapping("/create-edit")
    public String submitCustomer(@ModelAttribute("action") String action,
                                 @Valid @ModelAttribute("customer") Customer customer,
                                 BindingResult bindingResult,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.customer", bindingResult);
            redirectAttributes.addFlashAttribute("customer", customer);
            return "redirect:/customer/" + action + "?id=" + customer.getId();
        }
        customerService.save(customer);
        return "redirect:/customer/";
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam int id) {
        customerService.delete(id);
        return new ModelAndView("redirect:/customer/");
    }

    @GetMapping("/view")
    public ModelAndView view(@RequestParam int id,
                             HttpServletRequest request) {
        System.out.println(request.getRequestURI());
        return new ModelAndView("/customer/view", "customer", customerService.findById(id));
    }
}

