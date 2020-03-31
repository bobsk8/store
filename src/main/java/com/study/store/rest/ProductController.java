package com.study.store.rest;

import java.util.List;

import com.study.store.model.Product;
import com.study.store.service.IProductService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/store")
@CrossOrigin(origins = "*")
public class ProductController {

    IProductService productService;

    @PostMapping("/products")
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping("/products")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/products/{id}")
    public Product getById(@PathVariable("id") Long id) {
        return productService.getById(id);
    }

    @PutMapping("/products")
    public void update(@RequestBody Product product) {
        productService.update(product);
    }

    @DeleteMapping("/products")
    public void delete(@PathVariable("id") Long id) {
        productService.delete(id);
    }

}