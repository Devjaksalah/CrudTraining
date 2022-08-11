package com.CrudTraining.CrudTraining.service;

import com.CrudTraining.CrudTraining.model.Product;
import com.CrudTraining.CrudTraining.repository.ProductRespository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

//@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRespository productRespository;

    public List<Product> findAll()
    {
        return productRespository.findAll();
    }

    public Optional<Product> findById(Long id)
    {
        return productRespository.findById(id);
    }

    public Product save(Product product)
    {
        return productRespository.save(product);
    }

    public void deleteById(Long id)
    {
        productRespository.deleteById(id);
    }
}
