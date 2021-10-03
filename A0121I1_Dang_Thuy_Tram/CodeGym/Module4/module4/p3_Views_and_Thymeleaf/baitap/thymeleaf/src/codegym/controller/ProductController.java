package codegym.controller;

import codegym.entity.Product;
import codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
//    @Autowired
//    ProductService userService;
    @Autowired
    ProductService productService;

    @GetMapping("/index")
    public String index(Model model) {
        List<Product> products = productService.getListProduct();
        model.addAttribute("products", products);
        return "product/index";
    }

    @GetMapping("/create")
    public String displayCreate(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("action", "create");
        return "product/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product, @RequestParam String action, RedirectAttributes redirectAttributes) {
        productService.saveOrEdit(product);
        if ("create".equals(action)) {
            redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        } else if ("edit".equals(action)) {
            redirectAttributes.addFlashAttribute("message", "Update thành công");
        }

        return "redirect:/product/index";
    }

    @GetMapping("/edit/{id}")
    public String displayEdit(@PathVariable String id ,Model model) {
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        model.addAttribute("action", "edit");
        return "product/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        productService.deleteProduct(productService.getProduct(id));
        return "redirect:/product/index";
    }

    @GetMapping("/detail/{id}")
    public String displayDetail(@PathVariable String id ,Model model) {
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "product/detail";
    }
}