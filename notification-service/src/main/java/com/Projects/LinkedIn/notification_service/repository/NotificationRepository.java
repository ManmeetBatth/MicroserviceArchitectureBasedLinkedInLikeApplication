package com.Projects.LinkedIn.notification_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Projects.LinkedIn.notification_service.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

    
}