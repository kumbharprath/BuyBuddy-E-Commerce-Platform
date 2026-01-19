package com.example.buy_buddy_order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.buy_buddy_order_service.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}