package dev.marques.config;

import dev.marques.producer.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Log4j2
public class LineRunner implements CommandLineRunner {

    private final ProducerService producerService;

    @Override
    public void run(String... args) throws Exception {
        producerService.sendMessage();
    }
}
