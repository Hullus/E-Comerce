package com.ecommerce.product_service.product;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public ProductModel createProduct(ProductModel dto){
        return productRepo.save(dto);
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
}