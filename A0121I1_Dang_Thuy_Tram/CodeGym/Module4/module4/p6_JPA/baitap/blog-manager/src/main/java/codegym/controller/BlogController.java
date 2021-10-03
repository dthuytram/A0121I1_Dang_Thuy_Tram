package codegym.controller;

import codegym.bean.Blog;
import codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @GetMapping("/index")
    public String getList(Model model){
        List<Blog> blogs = blogService.listBogs();
        model.addAttribute("blogs",blogs);
        return "index";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("action","create");
        return "create";
    }
    @PostMapping("/create")
    public String create(Model model, @ModelAttribute Blog blog){
        blogService.SaveOrEdit(blog);
        model.addAttribute("action","add Successful");
        return "redirect:/index";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable(name = "id") int id,Model model){
        Blog blog = blogService.view(id);
        model.addAttribute("blog",blog);
        model.addAttribute("action","edit");
        return "create";
    }
    @GetMapping("/delete/{id}")
    public String detele(@PathVariable(name = "id") int id,Model model){
        blogService.delete(id);
        return "redirect:/index";
    }
    @GetMapping("/view/{id}")
    public String showView(@PathVariable(name = "id") int id,Model model){
        Blog blog = blogService.view(id);
        model.addAttribute("blog",blog);
        return "view";
    }

}
