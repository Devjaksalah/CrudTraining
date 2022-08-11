package com.CrudTraining.CrudTraining.model;



import lombok.Data;

import java.math.BigDecimal;


@Data

@Entiy
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;


}
