
package com.klu.controller;

import com.klu.model.Product;
import com.klu.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository repo;

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return repo.save(product);
    }

    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category){
        return repo.findByCategory(category);
    }

    @GetMapping("/filter")
    public List<Product> filterPrice(@RequestParam double min,@RequestParam double max){
        return repo.findByPriceBetween(min,max);
    }

    @GetMapping("/sorted")
    public List<Product> sortedProducts(){
        return repo.getProductsSorted();
    }

    @GetMapping("/expensive/{price}")
    public List<Product> expensiveProducts(@PathVariable double price){
        return repo.getExpensiveProducts(price);
    }
}
