package com.CrudTraining.CrudTraining.mapper;

import com.CrudTraining.CrudTraining.dto.ProductDTO;
import com.CrudTraining.CrudTraining.model.Product;

import java.util.List;

@Mapper
public class ProductMapper {

    ProductDTO toProductDTO(Product product);

    List<ProductDTO> toProductDTOs(List<Product> products);

    Product toProduct(ProductDTO productDTO);
}
