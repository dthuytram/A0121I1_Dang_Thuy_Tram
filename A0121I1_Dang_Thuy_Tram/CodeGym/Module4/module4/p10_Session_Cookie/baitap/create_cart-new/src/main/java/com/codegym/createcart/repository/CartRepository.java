package com.codegym.createcart.repository;

import com.codegym.createcart.model.Cart;
import com.codegym.createcart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {
}
