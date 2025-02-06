package com.soa.LibraryMicroservice.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StatisticsPubliser {
    private static final String TOPIC = "statistics";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publishStatistics(String message) {

        kafkaTemplate.send(TOPIC, message);
    }
}
