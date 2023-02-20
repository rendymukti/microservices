package com.learnadvancedconcept.productservice.repository;

import com.learnadvancedconcept.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
