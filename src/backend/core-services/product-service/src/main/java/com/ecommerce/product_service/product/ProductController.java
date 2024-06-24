
package com.ecommerce.product_service.product;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



/**
 * productController
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping()
    public ProductModel postMethodName(@RequestBody ProductModel entity) {
        return productService.createProduct(entity);
    }
    

    @GetMapping("/{id}")
    public ProductModel getProduct(@RequestParam Long id) {
        ProductModel product = productService.getProduct(id);
        return product;
    }

    @GetMapping()
    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }
    
    @DeleteMapping("/{id}")
    public void deleteProduct(@RequestParam Long id){
        productService.deleteProduct(id);
    }
    
}