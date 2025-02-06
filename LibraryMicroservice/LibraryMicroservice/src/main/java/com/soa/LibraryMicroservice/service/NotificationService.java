package com.soa.LibraryMicroservice.service;

import com.soa.LibraryMicroservice.domain.entity.Notification;
import com.soa.LibraryMicroservice.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public List<Notification> getAllNotification() {
        return notificationRepository.findAll();
    }
}
