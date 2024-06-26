package com.ecommerce.product_service.product.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProductCreationDto {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer inventory;

    public ProductCreationDto(String name, String description, BigDecimal price, Integer inventory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.inventory = inventory;
    }

    public static ProductCreationDto createProductDto(String name, String description, BigDecimal price, Integer inventory) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be non-negative");
        }
        if (inventory == null || inventory < 0) {
            throw new IllegalArgumentException("Inventory must be non-negative");
        }    

        return new ProductCreationDto(name, description, price, inventory);
    }
}
