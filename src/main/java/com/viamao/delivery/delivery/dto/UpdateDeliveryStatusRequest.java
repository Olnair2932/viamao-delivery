package com.viamao.delivery.delivery.dto;

import com.viamao.delivery.delivery.domain.DeliveryStatus;

public class UpdateDeliveryStatusRequest {
    private DeliveryStatus status;
    public DeliveryStatus getStatus() { return status; }
    public void setStatus(DeliveryStatus status) { this.status = status; }
}
