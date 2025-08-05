package dev.marques.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final StringRedisTemplate stringRedisTemplate;

    private static final String CACHE_KEY = "product-list";

    public void saveAll(String productsList) {
        stringRedisTemplate.opsForValue().set(CACHE_KEY, productsList, 10, TimeUnit.MINUTES);
    }

    public String getProductList() {
        return stringRedisTemplate.opsForValue().get(CACHE_KEY);
    }
}
