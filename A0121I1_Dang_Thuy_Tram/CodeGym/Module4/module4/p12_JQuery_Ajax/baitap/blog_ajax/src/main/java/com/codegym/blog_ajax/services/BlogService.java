package com.codegym.blog_ajax.services;

import com.codegym.blog_ajax.models.Blog;
import java.util.List;

public interface BlogService {
    List<Blog> findAllBlog();

    Blog findById(int id);

    void save(Blog blog);

    void delete(int id);
}
