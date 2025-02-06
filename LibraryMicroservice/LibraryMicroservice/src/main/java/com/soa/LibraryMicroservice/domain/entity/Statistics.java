package com.soa.LibraryMicroservice.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.lang.NonNull;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "statistics")
public class Statistics {
    @Id
    private String id;

    @Column
    @NonNull
    private int noReadings;

    @Column
    @NonNull
    private String title;
}
