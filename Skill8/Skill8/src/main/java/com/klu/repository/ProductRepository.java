
package com.klu.repository;

import com.klu.model.Product;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min,double max);

    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> getProductsSorted();

    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> getExpensiveProducts(double price);

    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> getProductsByCategory(String category);
}
