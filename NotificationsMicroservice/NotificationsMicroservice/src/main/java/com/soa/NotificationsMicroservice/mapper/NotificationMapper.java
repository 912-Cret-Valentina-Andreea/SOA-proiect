package com.soa.NotificationsMicroservice.mapper;

import com.soa.NotificationsMicroservice.model.Notification;
import com.soa.NotificationsMicroservice.model.NotificationRabbitDto;
import org.mapstruct.Mapper;

@Mapper
public interface NotificationMapper {
    Notification map(NotificationRabbitDto notificationRabbitDto, String id);
}
