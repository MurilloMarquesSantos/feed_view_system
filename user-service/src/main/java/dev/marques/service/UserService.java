package dev.marques.service;

import dev.marques.dto.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {

    private final RestTemplate restTemplate;

    public List<Product> listProducts() {
        ResponseEntity<List<Product>> response = restTemplate.exchange("http://localhost:8081/home",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        log.info(response);
        return response.getBody();

    }
}
