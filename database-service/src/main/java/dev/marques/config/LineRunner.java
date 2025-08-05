package dev.marques.config;

import dev.marques.domain.Product;
import dev.marques.repository.ProductRepository;
import dev.marques.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@Log4j2
public class LineRunner implements CommandLineRunner {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final JsonUtil jsonUtil;

    private final ProductRepository productRepository;

    @Value("${spring.kafka.topic.feed}")
    private String feedTopic;

    @Override
    public void run(String... args) throws Exception {
        List<Product> productList = productRepository.findAll();

        String payload = jsonUtil.toJson(productList);
        try {
            kafkaTemplate.send(feedTopic, payload);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }
}
