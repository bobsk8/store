package com.study.store.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.study.store.exception.RecordNotFoundException;
import com.study.store.model.Product;
import com.study.store.repository.IProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public List<Product> getAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Product> pagedResult = productrepo.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Product>();
        }
    }

    @Override
    public Product getById(Long id) throws RecordNotFoundException {
        Optional<Product> product = productrepo.findById(id);        
        if(product.isPresent()) {
            return product.get();
        } else {
            throw new RecordNotFoundException("No products record exist for given id");
        }
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