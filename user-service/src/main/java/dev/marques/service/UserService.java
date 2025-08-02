package dev.marques.service;

import dev.marques.dto.Product;
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

    private final RestTemplate restTemplate;
    public List<Product> listProducts() {
        ResponseEntity<List<Product>> response = restTemplate.exchange("http://localhost:8081/home",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        return response.getBody();

    }
}
