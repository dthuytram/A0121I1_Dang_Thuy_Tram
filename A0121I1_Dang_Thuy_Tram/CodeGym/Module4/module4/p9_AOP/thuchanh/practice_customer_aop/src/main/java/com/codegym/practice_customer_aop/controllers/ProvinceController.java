package com.codegym.practice_customer_aop.controllers;

import com.codegym.practice_customer_aop.models.Province;
import com.codegym.practice_customer_aop.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;

    @GetMapping("/provinces")
    public ModelAndView listProvinces(@PageableDefault(size = 5) Pageable pageable){
        Page<Province> provinces = provinceService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/province/listprovince");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/create-province")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/province/createprovince");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/create-province")
    public ModelAndView saveProvince(@ModelAttribute("province") Province province){
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("/province/createprovince");
        modelAndView.addObject("province",new Province());
        modelAndView.addObject("massage","New province created successfully");
        return modelAndView;
    }
    @GetMapping("/edit-province/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        Province province = provinceService.findById(id);
        if(province != null) {
            ModelAndView modelAndView = new ModelAndView("/province/editprovince");
            modelAndView.addObject("province", province);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-province")
    public ModelAndView updateProvince(@ModelAttribute("province") Province province){
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("/province/editprovince");
        modelAndView.addObject("province", province);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-province/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id){
        Province province = provinceService.findById(id);
        if(province != null) {
            ModelAndView modelAndView = new ModelAndView("/province/deleteprovince");
            modelAndView.addObject("province", province);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-province")
    public String deleteProvince(@ModelAttribute("province") Province province){
        provinceService.remove(province.getId());
        return "redirect:provinces";
    }

}
