package com.soa.NotificationsMicroservice.repository;

import com.soa.NotificationsMicroservice.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, String> {
}
