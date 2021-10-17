package com.codegym.validation.controllers;


import com.codegym.validation.models.Customer;
import com.codegym.validation.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView listCustomers(){
        List<Customer> customers = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public String saveCustomer(@Validated @ModelAttribute("customer") Customer customer,  BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }else {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return "redirect:/customers";
        }
    }
    @GetMapping("/edit-customer/{id}")
    public String showEditForm(@PathVariable int id, Model model){
        Customer customer = customerService.findById(id);
        if(customer != null) {
            model.addAttribute("customer", customer);
            return "edit";
        }
        else {
            return "list";
        }
    }

    @PostMapping("/edit-customer")
    public String updateCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()) {
            return "edit";
        }else {
        customerService.save(customer);
        model.addAttribute("customer", customer);
        model.addAttribute("message", "Customer updated successfully");
        return "redirect:/customers";
        }
    }


    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id){
        Customer customer = customerService.findById(id);
        if(customer != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer){
        customerService.remove(customer.getId());
        return "redirect:/customers";
    }
}
