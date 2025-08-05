//package dev.marques.controller;
//
//import dev.marques.domain.Product;
//import dev.marques.service.ProductService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/home")
//public class ProductController {
//
//    private final ProductService productService;
//
//    @GetMapping
//    public ResponseEntity<List<Product>> getProducts() {
//        return ResponseEntity.ok(productService.getProducts());
//    }
//}
