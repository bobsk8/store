package com.study.store.service;

import java.util.List;

import com.study.store.model.Product;

public interface IProductService {

    Product create(Product product);

    List<Product> getAll();

    Product getById(Long id);

    void update(Product product);

    void delete(Long id);

}