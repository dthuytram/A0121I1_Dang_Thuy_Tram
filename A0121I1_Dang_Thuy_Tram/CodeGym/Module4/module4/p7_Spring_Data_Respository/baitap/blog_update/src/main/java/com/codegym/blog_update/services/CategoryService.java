package com.codegym.blog_update.services;

import com.codegym.blog_update.models.Blog;
import com.codegym.blog_update.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    Page<Category> findAllBlog(Pageable pageable);

    Category findById(int id);

    void save(Category category);

    void delete(int id);
}
