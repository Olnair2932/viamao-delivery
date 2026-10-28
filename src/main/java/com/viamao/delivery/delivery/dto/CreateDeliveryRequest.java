package com.viamao.delivery.delivery.dto;

import java.util.UUID;

public class CreateDeliveryRequest {
    private UUID orderId;
    private String courierName;

    public UUID getOrderId() { return orderId; }
    public void setOrderId(UUID orderId) { this.orderId = orderId; }
    public String getCourierName() { return courierName; }
    public void setCourierName(String courierName) { this.courierName = courierName; }
}
