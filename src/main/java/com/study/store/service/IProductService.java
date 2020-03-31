package com.study.store.service;

import java.util.List;

import com.study.store.exception.RecordNotFoundException;
import com.study.store.model.Product;

public interface IProductService {

    Product create(Product product);

    List<Product> getAll(Integer pageNo, Integer pageSize, String sortBy);

    Product getById(Long id) throws RecordNotFoundException;

    void update(Product product);

    void delete(Long id);

}