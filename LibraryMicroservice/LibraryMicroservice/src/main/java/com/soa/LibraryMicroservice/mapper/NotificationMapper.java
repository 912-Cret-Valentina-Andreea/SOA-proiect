package com.soa.LibraryMicroservice.mapper;


import com.library.model.NotificationDto;
import com.soa.LibraryMicroservice.domain.entity.Notification;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface NotificationMapper {
    NotificationDto map(Notification notification);
    List<NotificationDto> map(List<Notification> notification);
}
