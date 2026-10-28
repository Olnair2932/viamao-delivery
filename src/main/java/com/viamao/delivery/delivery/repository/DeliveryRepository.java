package com.viamao.delivery.delivery.repository;

import com.viamao.delivery.delivery.domain.Delivery;
import com.viamao.delivery.delivery.domain.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, UUID> {
    List<Delivery> findByStatus(DeliveryStatus status);
    Optional<Delivery> findByOrderId(UUID orderId);
}
