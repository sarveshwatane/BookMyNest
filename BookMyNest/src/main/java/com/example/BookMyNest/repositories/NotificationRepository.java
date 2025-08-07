package com.example.BookMyNest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookMyNest.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
