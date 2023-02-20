package com.learnadvancedconcept.productservice.service;

import com.learnadvancedconcept.productservice.dto.ProductRequest;
import com.learnadvancedconcept.productservice.dto.ProductResponse;
import com.learnadvancedconcept.productservice.model.Product;
import com.learnadvancedconcept.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;



    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);

        log.info("Product {} is saved", product.getId());



    }


    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();

    }

    private ProductResponse mapToProductResponse (Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .description(product.getDescription())
                .name((product.getName()))
                .build();
    }
}
