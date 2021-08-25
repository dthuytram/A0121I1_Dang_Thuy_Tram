package service;

import bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    int size();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    List<Product> search(String name);

    void remove(int id);
}
