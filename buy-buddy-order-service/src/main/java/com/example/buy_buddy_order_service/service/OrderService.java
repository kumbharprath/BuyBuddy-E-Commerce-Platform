package com.example.buy_buddy_order_service.service;

import java.util.List;

import com.example.buy_buddy_order_service.dto.OrderRequest;
import com.example.buy_buddy_order_service.dto.OrderResponse;
import com.example.buy_buddy_order_service.model.Order;

public interface OrderService {
    List<Order> getAllOrders();
    OrderResponse getOrderById(Long id);
    Order createOrder(OrderRequest orderRequest);
    void deleteOrder(Long id);
}
