package com.study.store.rest;

import java.util.List;

import com.study.store.exception.RecordNotFoundException;
import com.study.store.model.Product;
import com.study.store.service.IProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/store")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    IProductService productService;

    @PostMapping("/products")
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping("/products")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAll(
                @RequestParam(defaultValue = "0") Integer pageNo, 
                @RequestParam(defaultValue = "10") Integer pageSize,
                @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<Product> list = productService.getAll(pageNo, pageSize, sortBy); 
        return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Long id) throws RecordNotFoundException {
        Product entity = productService.getById(id); 
        return new ResponseEntity<Product>(entity, new HttpHeaders(), HttpStatus.OK);        
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