package dev.marques.listener;

import dev.marques.dto.Product;
import dev.marques.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final JsonUtil jsonUtil;

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "${spring.kafka.topic.feed}"
    )
    public void consumerFeedTopic(String payload) {
        List<Product> productList = jsonUtil.toProductList(payload);
    }
}
