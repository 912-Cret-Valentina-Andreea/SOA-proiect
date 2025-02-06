package com.soa.LibraryMicroservice.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationRabbitDto {
    private String title;
    private boolean status;
}
