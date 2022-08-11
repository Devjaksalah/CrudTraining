package com.CrudTraining.CrudTraining.controller;

import com.CrudTraining.CrudTraining.dto.ProductDTO;
import com.CrudTraining.CrudTraining.mapper.ProductMapper;
import com.CrudTraining.CrudTraining.model.Product;
import com.CrudTraining.CrudTraining.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO)
    {
        System.out.println(productDTO);
        Product product = productMapper.toProduct(productDTO);
        System.out.println("productMapper = " + productMapper);
        System.out.println(product);
        System.out.println("productService = " + productService);
        productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id)
    {
        Optional<Product> product = productService.findById(id);
        ProductDTO productDTO = productMapper.toProductDTO(product.get());
        return ResponseEntity.ok(productDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id,	@RequestBody ProductDTO productDTO)
    {
        Product product = productMapper.toProduct(productDTO);
        product.setId(id);

        productService.save(product);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        productService.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll()
    {
        List<ProductDTO> productList = productMapper.toProductDTOs(productService.findAll());
        return ResponseEntity.ok(productList);
    }

}
