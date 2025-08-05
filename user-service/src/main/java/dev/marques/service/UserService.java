package dev.marques.service;

import dev.marques.dto.Product;
import dev.marques.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


//    Uncomment this when trying rest communication

//    private final RestTemplate restTemplate;
//
//    public List<Product> listProducts() {
//        ResponseEntity<List<Product>> response = restTemplate.exchange("http://localhost:8082/home",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<>() {
//                });
//        return response.getBody();
//
//    }

    private final RedisService redisService;

    private final JsonUtil jsonUtil;

    public List<Product> listProducts() {
        String productList = redisService.getProductList();
        return jsonUtil.toProductList(productList);
    }

//    Uncomment this when trying string response
//    public String listProducts() {
//        return redisService.getProductList();
//    }
}
