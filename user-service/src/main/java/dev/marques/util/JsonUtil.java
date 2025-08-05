package dev.marques.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.marques.dto.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Log4j2
public class JsonUtil {

    private final ObjectMapper objectMapper;

    public String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Error while converting object to json", e);
            return null;
        }
    }

    public List<Product> toProductList(String payload) {
        try {
            return objectMapper.readValue(payload, new TypeReference<List<Product>>() {
            });
        } catch (JsonProcessingException e) {
            log.error("Error while converting json to product list", e);
            return List.of();
        }
    }


}
