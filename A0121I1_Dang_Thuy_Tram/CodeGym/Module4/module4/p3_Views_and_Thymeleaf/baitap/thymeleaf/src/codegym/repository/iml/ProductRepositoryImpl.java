package codegym.repository.iml;

import codegym.entity.Product;
import codegym.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static HashMap<String, Product> products = new HashMap<>();

    static {
        products.put("sp01", new Product("sp01","đồng","hàng mới",1000,"nhà kim đồng"));
        products.put("sp02", new Product("sp02","Bánd phím xịn","hàng mới",1000,"nhà tui"));
        products.put("sp03", new Product("sp03","Máy tính cute","hàng mới",1000,"nhà người ta"));
        products.put("sp04", new Product("sp04","Tiền","hàng mới",1000,"nhà nước"));

    }

    @Override
    public Product getProduct(String id) {
        return products.get(id);
    }

    @Override
    public List<Product> getListProduct() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void saveProduct(Product product) {
        products.put(product.getIdProduct(), product);
    }

    @Override
    public void editProduct(Product product) {
        if (products.containsKey(product.getIdProduct())) {
            products.put(product.getIdProduct(), product);
        }
    }

    @Override
    public void deleteProduct(Product product) {
        if (products.containsKey(product.getIdProduct())) {
            products.remove(product.getIdProduct());
        }
    }

    @Override
    public void saveOrEdit(Product product) {
        products.put(product.getIdProduct(),product);
    }
}
