package com.study.store.repository;

import com.study.store.model.Product;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {

    
}