package repository;

import bean.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
        private static List<Product> products;

        static {
            products = new ArrayList<>();
            products.add(new Product(0, "May tinh Dell", 14999000, 45, "China"));
            products.add(new Product(1, "May tinh HP", 15999000, 69, "USA"));
            products.add(new Product(2, "Dien Thoai Nokia", 499000, 99, "China"));
            products.add(new Product(3, "Dien thoai Sam Sung", 3999000, 12, "Japan"));
        }

        @Override
        public List<Product> findAll() {
            return products;
        }

        @Override
        public int size() {
            return products.size();
        }

        @Override
        public void save(Product product) {
            products.add(product);
        }

        @Override
        public Product findById(int id) {
            return products.get(id);
        }

        @Override
        public void update(int id, Product product) {
            products.add(id, product);
        }

        public List<Product> search(String name) {
            List<Product> products1 = new ArrayList<>();
            for (Product product : products) {
                if (product.getName().contains(name)) {
                    products1.add(product);
                }
            }
            return products1;
        }

        @Override
        public void remove(int id) {
            products.remove(id);
        }
}
