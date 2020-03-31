package com.study.store.service;

import java.util.List;

import com.study.store.model.Product;
import com.study.store.repository.IProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductRepository productrepo;

    @Override
    public Product create(Product product) {
        return productrepo.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productrepo.findAll();
    }

    @Override
    public Product getById(Long id) {        
        return productrepo.getOne(id);
    }

    @Override
    public void update(Product product) {
        productrepo.save(product);
    }

    @Override
    public void delete(Long id) {
        productrepo.deleteById(id);
    }

    
}