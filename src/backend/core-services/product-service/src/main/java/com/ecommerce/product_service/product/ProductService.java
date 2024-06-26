package com.ecommerce.product_service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.product_service.product.dto.ProductCreationDto;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public ProductModel createProduct(ProductCreationDto dto){
        var newProduct = toProductModel(dto);
        return productRepo.save(newProduct);
    }

    public ProductModel getProduct(Long id){
        return productRepo.findById(id).orElse(null);
    }

    public List<ProductModel> getAllProducts(){
        return productRepo.findAll();
    }

    public void deleteProduct(Long id){
        productRepo.deleteById(id);
    }

    public static ProductModel toProductModel(ProductCreationDto dto) {
        return ProductModel.createProduct(
            dto.getName(),
            dto.getDescription(),
            dto.getPrice(),
            dto.getInventory()
        );
    }
 
}