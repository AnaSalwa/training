package com.example.training.Service;


import com.example.training.Model.Product;
import com.example.training.Repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    public ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> addProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    public Product findProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Page<Product> getProducts(int page, int size ) {
        Pageable pageable = PageRequest.of(page,size);
        return productRepository.findAll(pageable);
    }

    public void deleteProduct(Long id) {
        if(productRepository.existsById(id)) {
            productRepository.deleteById(id);
            System.out.println("Successfully delete");
        }else{
            throw new RuntimeException("Product Not Found");
        }
    }



}
