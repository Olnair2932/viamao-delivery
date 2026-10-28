package com.viamao.delivery.order.repository;

import com.viamao.delivery.order.domain.Order;
import com.viamao.delivery.order.domain.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    List<Order> findByStatus(OrderStatus status);
    List<Order> findByCustomerNameContainingIgnoreCase(String customerName);
}
