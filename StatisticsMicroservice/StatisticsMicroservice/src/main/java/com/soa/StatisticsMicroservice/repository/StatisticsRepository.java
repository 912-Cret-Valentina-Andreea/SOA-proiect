package com.soa.StatisticsMicroservice.repository;

import com.soa.StatisticsMicroservice.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, String> {
    Optional<Statistics> findByTitle(String title);
}
