package codegym.controller;

import codegym.entity.User;
import codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/index")
    public String index(Model model) {
        List<User> users = userService.getListUser();
        model.addAttribute("users", users);
        model.addAttribute("user1", "Linh");
        model.addAttribute("user2", "Bao");
        return "user/index";
    }

    @GetMapping("/create")
    public String displayCreate(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute User user) {
        userService.saveOrEdit(user);
        return "redirect:/user/index";
    }

    @GetMapping("/edit/{id}")
    public String displayEdit(@PathVariable int id ,Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        userService.deleteUser(userService.getUser(id));
        return "redirect:/user/index";
    }

    @GetMapping("/detail/{id}")
    public String displayDetail(@PathVariable int id ,Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user/detail";
    }
}
