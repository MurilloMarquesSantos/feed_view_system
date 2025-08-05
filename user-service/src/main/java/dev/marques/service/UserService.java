package dev.marques.service;

import dev.marques.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

//    private final RestTemplate restTemplate;
//
//    public List<Product> listProducts() {
//        ResponseEntity<List<Product>> response = restTemplate.exchange("http://localhost:8081/home",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<>() {
//                });
//        return response.getBody();
//
//    }

    private final RedisService redisService;

    private final JsonUtil jsonUtil;

//    public List<Product> listProducts() {
//        String productList = redisService.getProductList();
//        return jsonUtil.toProductList(productList);
//    }

    public String listProducts() {
        return redisService.getProductList();
    }
}
