package com.soa.NotificationsMicroservice.service;

import com.soa.NotificationsMicroservice.mapper.NotificationMapper;
import com.soa.NotificationsMicroservice.model.NotificationRabbitDto;
import com.soa.NotificationsMicroservice.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.soa.NotificationsMicroservice.configuration.RabbitMqConfig.NOTIFICATION_QUEUE;

@Service
@RequiredArgsConstructor
public class RabbitMqListener {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    @RabbitListener(
            queues = NOTIFICATION_QUEUE,
            autoStartup = "true"
    )
    public void processCustomerOrder(NotificationRabbitDto notificationRabbitDto) {
        var emailSent = notificationMapper.map(notificationRabbitDto, UUID.randomUUID().toString());
        notificationRepository.save(emailSent);
    }
}
