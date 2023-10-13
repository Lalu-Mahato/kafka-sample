package com.example.kafkaproducerdemo.config;

import java.util.Collections;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {
    @Bean
    public NewTopic createTopic() {
        String topicName = "topic-nst";
        // long retentionMs = 86400000; // 24 hours
        long retentionMs = 5000;

        return new NewTopic(topicName, 5, (short) 1)
                .configs(Collections.singletonMap("retention.ms", String.valueOf(retentionMs)));

    }
}
