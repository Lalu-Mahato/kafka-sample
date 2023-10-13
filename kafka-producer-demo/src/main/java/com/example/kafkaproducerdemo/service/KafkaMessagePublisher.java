package com.example.kafkaproducerdemo.service;

import java.util.concurrent.CompletableFuture;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessagePublisher {
    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String message) {
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>("topic-nst", message);

        CompletableFuture<SendResult<String, Object>> future = template.send(producerRecord);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println(
                        "Sent message =[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message =[" + message + "] due to :" + ex.getMessage());

            }
        });
    }
}
