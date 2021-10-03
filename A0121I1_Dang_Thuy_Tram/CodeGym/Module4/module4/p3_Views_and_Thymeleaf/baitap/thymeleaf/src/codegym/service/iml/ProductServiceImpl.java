package codegym.service.iml;

import codegym.entity.Product;
import codegym.repository.ProductRepository;
import codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProduct(String id) {
        return productRepository.getProduct(id);
    }

    @Override
    public List<Product> getListProduct() {
        return productRepository.getListProduct();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }

    @Override
    public void editProduct(Product product) {
        productRepository.editProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.deleteProduct(product);
    }

    @Override
    public void saveOrEdit(Product product) {
        productRepository.saveOrEdit(product);
    }
}
