package com.viamao.delivery.delivery.dto;

import com.viamao.delivery.delivery.domain.Delivery;
import com.viamao.delivery.delivery.domain.DeliveryStatus;
import java.time.LocalDateTime;
import java.util.UUID;

public class DeliveryResponse {
    private UUID id;
    private UUID orderId;
    private String courierName;
    private DeliveryStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static DeliveryResponse from(Delivery d) {
        DeliveryResponse r = new DeliveryResponse();
        r.id = d.getId();
        r.orderId = d.getOrderId();
        r.courierName = d.getCourierName();
        r.status = d.getStatus();
        r.createdAt = d.getCreatedAt();
        r.updatedAt = d.getUpdatedAt();
        return r;
    }

    public UUID getId() { return id; }
    public UUID getOrderId() { return orderId; }
    public String getCourierName() { return courierName; }
    public DeliveryStatus getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
