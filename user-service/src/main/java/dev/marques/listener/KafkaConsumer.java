package dev.marques.listener;

import dev.marques.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final RedisService redisService;

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "${spring.kafka.topic.feed}"
    )
    public void consumerFeedTopic(String payload) {
        redisService.saveAll(payload);
    }
}
