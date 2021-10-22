package com.codegym.blog_ajax.controllers;


import com.codegym.blog_ajax.models.Blog;
import com.codegym.blog_ajax.services.impl.BlogServiceImpl;
import com.codegym.blog_ajax.services.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    BlogServiceImpl blogService;

    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping
    public String index(Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("blogs", blogService.findAllBlog());
        return "/blog/list_blog";
    }

    @GetMapping("/create")
    public ModelAndView getFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("categories", categoryService.findAllCatelogies());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("success", "Saved blog successfully!");
        return "redirect:/blogs";
    }


    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categories", categoryService.findAllCatelogies());
        return "/blog/edit";
    }

    @PostMapping("/edit")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addAttribute("success", "Updated blog successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        blogService.delete(blog.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }
}
