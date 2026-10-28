package com.viamao.delivery.order.service;

import com.viamao.delivery.order.domain.Order;
import com.viamao.delivery.order.domain.OrderStatus;
import com.viamao.delivery.order.dto.CreateOrderRequest;
import com.viamao.delivery.order.dto.OrderResponse;
import com.viamao.delivery.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public OrderResponse create(CreateOrderRequest req) {
        Order order = new Order();
        order.setCustomerName(req.getCustomerName());
        order.setDeliveryAddress(req.getDeliveryAddress());
        order.setTotalAmount(req.getTotalAmount());
        order.setStatus(OrderStatus.CREATED);
        return OrderResponse.from(repository.save(order));
    }

    public OrderResponse findById(UUID id) {
        Order order = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado: " + id));
        return OrderResponse.from(order);
    }

    public List<OrderResponse> findAll() {
        return repository.findAll().stream()
            .map(OrderResponse::from)
            .collect(Collectors.toList());
    }

    public List<OrderResponse> findByStatus(OrderStatus status) {
        return repository.findByStatus(status).stream()
            .map(OrderResponse::from)
            .collect(Collectors.toList());
    }

    @Transactional
    public OrderResponse updateStatus(UUID id, OrderStatus status) {
        Order order = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado: " + id));
        order.setStatus(status);
        return OrderResponse.from(repository.save(order));
    }
}
