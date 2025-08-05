package dev.marques.producer;

import dev.marques.domain.Product;
import dev.marques.repository.ProductRepository;
import dev.marques.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Log4j2
public class ProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final JsonUtil jsonUtil;

    private final ProductRepository productRepository;

    @Value("${spring.kafka.topic.feed}")
    private String feedTopic;

    public void sendMessage() {
        List<Product> productList = productRepository.findAll();

        String payload = jsonUtil.toJson(productList);
        try {
            kafkaTemplate.send(feedTopic, payload);
        } catch (Exception e) {
            log.error("FAIL: {} ", e.getMessage());
            log.error(e);
        }
    }
}
