package com.soa.NotificationsMicroservice.model;

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
@Table(name = "notification")
public class Notification {
    @Id
    private String id;

    @Column
    @NonNull
    private String title;

    @Column
    @NonNull
    private boolean status;
}
