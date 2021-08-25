package service;

import bean.Product;
import repository.IProductRepository;
import repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    private IProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public int size() {
        return productRepository.size();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public List<Product> search(String name) {
        return productRepository.search(name);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }
}
