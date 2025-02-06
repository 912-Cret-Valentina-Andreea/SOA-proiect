package com.soa.LibraryMicroservice.repository;

import com.soa.LibraryMicroservice.domain.entity.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, UUID> {
}
