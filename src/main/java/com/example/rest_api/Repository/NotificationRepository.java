package com.example.rest_api.Repository;

import com.example.rest_api.Entity.Notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // Các phương thức tùy chỉnh nếu cần
}
