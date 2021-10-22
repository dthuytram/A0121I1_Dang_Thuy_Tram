package com.codegym.blog_ajax.services.impl;

import com.codegym.blog_ajax.models.Blog;
import com.codegym.blog_ajax.repositories.BlogRepository;
import com.codegym.blog_ajax.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAllBlog() {
        return blogRepository.findAll() ;
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }
}
