package com.codegym.blog.services;

import com.codegym.blog.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> findAllBlog();

    Category findById(int id);

    void save(Category category);

    void delete(int id);
}
