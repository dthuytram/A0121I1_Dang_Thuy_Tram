package com.codegym.repository;


import com.codegym.model.Product;

import java.util.List;

public interface ProductRepository {
    Product findId(String idproduct);
    List<Product> listAll();
    void add(Product product);
    void update(Product product,String id);
    void delete(String id);
    List<Product> search(String name);
}
