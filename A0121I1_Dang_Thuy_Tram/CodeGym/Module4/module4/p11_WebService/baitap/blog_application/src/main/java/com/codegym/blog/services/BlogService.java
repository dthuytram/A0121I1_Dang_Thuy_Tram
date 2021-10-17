package com.codegym.blog.services;

import com.codegym.blog.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<Blog> findAllBlog();

    Blog findById(int id);

    void save(Blog blog);

    void delete(int id);
}
