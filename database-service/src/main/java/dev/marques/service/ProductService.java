package dev.marques.service;

import dev.marques.domain.Product;
import dev.marques.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

//    Uncomment this when trying rest communication
//
//    public List<Product> getProducts() {
//        return productRepository.findAll();
//    }
}
