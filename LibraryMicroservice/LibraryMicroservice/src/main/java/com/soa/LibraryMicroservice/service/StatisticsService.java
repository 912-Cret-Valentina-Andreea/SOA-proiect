package com.soa.LibraryMicroservice.service;

import com.soa.LibraryMicroservice.domain.entity.Statistics;
import com.soa.LibraryMicroservice.repository.StatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final StatisticsRepository statisticsRepository;

    public List<Statistics> getAllStatistics() {
        return statisticsRepository.findAll();
    }
}
