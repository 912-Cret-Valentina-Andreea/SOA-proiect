package com.soa.LibraryMicroservice.mapper;

import com.library.model.StatisticsDto;
import com.soa.LibraryMicroservice.domain.entity.Statistics;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface StatisticsMapper {
    StatisticsDto map(Statistics statistics);
    List<StatisticsDto> map(List<Statistics> analytics);
}
