package com.codegym.blog_ajax.repositories;


import com.codegym.blog_ajax.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
