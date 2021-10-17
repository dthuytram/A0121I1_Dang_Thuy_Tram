package com.codegym.blog.controllers;

import com.codegym.blog.models.Blog;
import com.codegym.blog.models.Category;
import com.codegym.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> showListCategories() {
        List<Category> categoryList = categoryService.findAllBlog();
        return ResponseEntity.ok(categoryList);
    }

    @PostMapping
    public ResponseEntity<Void> createCategory(@RequestBody Category category) {
        System.out.println("Creating Category: " + category.getNameCategory());
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editCategory(@RequestBody Category category, @PathVariable int id) {
        Category crCategory = categoryService.findById(id);
        if (crCategory == null) {
            return ResponseEntity.notFound().build();
        }
        category.setId(id);
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> viewCategory(@PathVariable int id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            System.out.println("Unable to delete. Customer with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
