package com.codegym.blog_ajax.services;

import com.codegym.blog_ajax.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> findAllCatelogies();

    Category findById(int id);

    void save(Category category);

    void delete(int id);
}
