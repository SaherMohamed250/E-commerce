package com.example.ecommerce.service;

import com.example.ecommerce.DTO.request.ProductRequest;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setStockQuantity(productRequest.getStockQuantity());
        product.setImageUrl(productRequest.getImageUrl());
        product.setActive(productRequest.isActive());
        productRepository.save(product);
        return product;
    }

    public Product updateProduct(Long id,ProductRequest productRequest) {
        Product product =productRepository.findById(id).get();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setStockQuantity(productRequest.getStockQuantity());
        product.setImageUrl(productRequest.getImageUrl());
        product.setActive(productRequest.isActive());
        productRepository.save(product);
        return product;
    }

    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "Product deleted";
    }
}
