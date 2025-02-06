package com.soa.LibraryMicroservice.service;

import com.soa.LibraryMicroservice.domain.NotificationRabbitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.soa.LibraryMicroservice.configuration.rabbitmq.RabbitMqConfig.NOTIFICATION_QUEUE;

@Service
@RequiredArgsConstructor
public class NotificationPublisher {
    private final RabbitTemplate rabbitTemplate;

    public void publishNotification(NotificationRabbitDto notificationRabbitDto) {
        rabbitTemplate.convertAndSend(NOTIFICATION_QUEUE, notificationRabbitDto);
    }
}
