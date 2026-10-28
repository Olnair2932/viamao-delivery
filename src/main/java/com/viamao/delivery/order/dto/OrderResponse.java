package com.viamao.delivery.order.dto;

import com.viamao.delivery.order.domain.Order;
import com.viamao.delivery.order.domain.OrderStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class OrderResponse {
    private UUID id;
    private String customerName;
    private String deliveryAddress;
    private BigDecimal totalAmount;
    private OrderStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static OrderResponse from(Order order) {
        OrderResponse r = new OrderResponse();
        r.id = order.getId();
        r.customerName = order.getCustomerName();
        r.deliveryAddress = order.getDeliveryAddress();
        r.totalAmount = order.getTotalAmount();
        r.status = order.getStatus();
        r.createdAt = order.getCreatedAt();
        r.updatedAt = order.getUpdatedAt();
        return r;
    }

    public UUID getId() { return id; }
    public String getCustomerName() { return customerName; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public OrderStatus getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
