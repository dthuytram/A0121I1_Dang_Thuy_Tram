package com.codegym.repository;

import com.codegym.model.Product;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImp implements ProductRepository {
    static Map<String, Product> stringProductMap;
    static {
        stringProductMap = new HashMap<>();
        stringProductMap.put("sp01",new Product("sp01","đồng","hàng mới",1000,"nhà kim đồng"));
        stringProductMap.put("sp02",new Product("sp02","sách","hàng mới",1000,"nhà kim đồng"));
        stringProductMap.put("sp03",new Product("sp03","sách","hàng mới",1000,"nhà kim đồng"));
    }

    @Override
    public Product findId(String idproduct) {
        return stringProductMap.get(idproduct);
    }

    @Override
    public List<Product> listAll() {
        return new ArrayList<>(stringProductMap.values());
    }

    @Override
    public void add(Product product) {
        stringProductMap.put(product.getIdProduct(),product);
    }


    @Override
    public void update(Product product, String id) {
        stringProductMap.put(id,product);
    }

    @Override
    public void delete(String id) {
        stringProductMap.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> products = new ArrayList<>();
        for (Map.Entry<String, Product> item : stringProductMap.entrySet()) {
            if(item.getValue().getNameProduct().contains(name)){
                products.add(item.getValue());
            }
        }
        return products;

    }
}
