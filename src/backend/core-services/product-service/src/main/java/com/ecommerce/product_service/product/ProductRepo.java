package com.ecommerce.product_service.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepo extends JpaRepository<Product, Long>{
    
}
