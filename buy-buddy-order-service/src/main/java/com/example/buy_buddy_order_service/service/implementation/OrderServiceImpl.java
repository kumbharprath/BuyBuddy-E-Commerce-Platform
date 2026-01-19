package com.example.buy_buddy_order_service.service.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.buy_buddy_order_service.dto.CustomerDTO;
import com.example.buy_buddy_order_service.dto.OrderRequest;
import com.example.buy_buddy_order_service.dto.OrderResponse;
import com.example.buy_buddy_order_service.dto.ProductDTO;
import com.example.buy_buddy_order_service.exception.ResourceNotFoundException;
import com.example.buy_buddy_order_service.feign.CustomerClient;
import com.example.buy_buddy_order_service.feign.ProductClient;
import com.example.buy_buddy_order_service.model.Order;
import com.example.buy_buddy_order_service.repository.OrderRepository;
import com.example.buy_buddy_order_service.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerClient customerClient;
    @Autowired
    private ProductClient productClient;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // @Override
    // public Order getOrderById(Long id) {
    //     return orderRepository.findById(id)
    //             .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
    // }
    @Override
    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
                        // Fetch customer details
        CustomerDTO customer = customerClient.getCustomerById(order.getCustomerId()).getBody();

                // Fetch product details for each product ID in the order
        List<ProductDTO> products = order.getProductIds().stream()
            .map(productId -> {
                ResponseEntity<ProductDTO> productResponse = productClient.getProductById(productId);
                return productResponse.getBody();
            })
            .collect(Collectors.toList());

            return new OrderResponse(order, customer, products);
    }

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        // Customer customer = customerRepository.findById(orderRequest.getCustomerId())
        //         .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + orderRequest.getCustomerId()));
        // List<Product> products = productRepository.findAllById(orderRequest.getProductIds());
        
        
        // if (products.size() != orderRequest.getProductIds().size()) {
        //     throw new ResourceNotFoundException("One or more products not found");
        // }

        Order order = new Order();

        order.setCustomerId(orderRequest.getCustomerId());
        order.setProductIds(orderRequest.getProductIds());
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        orderRepository.delete(order);
    }
}