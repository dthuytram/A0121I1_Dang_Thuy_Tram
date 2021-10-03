package codegym.repository;

import codegym.entity.Product;

import java.util.List;

public interface ProductRepository {
    Product getProduct(String id);
    List<Product> getListProduct();
    void saveProduct(Product product);
    void editProduct(Product product);
    void deleteProduct(Product product);
    void saveOrEdit(Product product);
}
