package com.codegym.blog_update.services;


import com.codegym.blog_update.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAllBlog(Pageable pageable);

    Blog findById(int id);

    void save(Blog blog);

    void delete(int id);
}
