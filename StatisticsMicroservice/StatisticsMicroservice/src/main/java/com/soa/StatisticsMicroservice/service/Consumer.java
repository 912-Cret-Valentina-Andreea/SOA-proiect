package com.soa.StatisticsMicroservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soa.StatisticsMicroservice.model.Book;
import com.soa.StatisticsMicroservice.model.Statistics;
import com.soa.StatisticsMicroservice.repository.StatisticsRepository;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class Consumer {
    private final StatisticsRepository statisticsRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "statistics", groupId = "group_id")
    public void consumeMessage(String data) throws JsonProcessingException {
        Book book = objectMapper.readValue(data, Book.class);
        var statistics = statisticsRepository.findByTitle(book.getTitle());
        if (statistics.isPresent()) {
            if(book.isStatus()) {
                statistics.get().setNoReadings(statistics.get().getNoReadings() + 1);
                statisticsRepository.save(statistics.get());
            }
        } else {
            statisticsRepository.save(Statistics.builder()
                    .id(UUID.randomUUID().toString())
                    .title(book.getTitle())
                    .noReadings(1)
                    .build());
        }
    }
}
