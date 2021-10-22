package com.codegym.blog_ajax.controllers;

import com.codegym.blog_ajax.models.Category;
import com.codegym.blog_ajax.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public String showListCategories(Model model){
        model.addAttribute("categories", categoryService.findAllCatelogies());
        return "list_category";
    }

    @GetMapping("/create")
    public String showCreateCategory(Model model){
        model.addAttribute("category", new Category());
        return "create_category";
    }

    @PostMapping("/create")
    public String createCategory(@ModelAttribute Category category, Model model){
        categoryService.save(category);
        model.addAttribute("success","Created Category Successful!");
        return "create_category";
    }

    @GetMapping("/edit")
    public String showEditCategory(@RequestParam int id, Model model){
        model.addAttribute("category", categoryService.findById(id));
        return "edit_category";
    }

    @PostMapping("/edit")
    public String editCategory(@ModelAttribute Category category, Model model){
        categoryService.save(category);
        model.addAttribute("success", "Edited Category!");
        return "redirect:/";
    }


    @GetMapping("/delete")
    public String showDeleteCategory(@RequestParam int id, Model model){
        model.addAttribute("category", categoryService.findById(id));
        return "delete_category";
    }

    @PostMapping("/delete")
    public String deleteCategory(@ModelAttribute Category category, Model model){
        categoryService.delete(category.getId());
        model.addAttribute("success", "Deleted Category!");
        return "redirect:/categories";
    }

    @GetMapping("view")
    public String viewCategory(@RequestParam int id, Model model){
        model.addAttribute("category",  categoryService.findById(id));
        return "view_category";
    }



}
