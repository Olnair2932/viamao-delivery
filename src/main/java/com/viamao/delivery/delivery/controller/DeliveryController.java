package com.viamao.delivery.delivery.controller;

import com.viamao.delivery.delivery.domain.DeliveryStatus;
import com.viamao.delivery.delivery.dto.CreateDeliveryRequest;
import com.viamao.delivery.delivery.dto.DeliveryResponse;
import com.viamao.delivery.delivery.dto.UpdateDeliveryStatusRequest;
import com.viamao.delivery.delivery.service.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/deliveries")
@CrossOrigin(origins = "*")
public class DeliveryController {
    private final DeliveryService service;

    public DeliveryController(DeliveryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DeliveryResponse> create(@RequestBody CreateDeliveryRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/by-order/{orderId}")
    public ResponseEntity<DeliveryResponse> findByOrderId(@PathVariable UUID orderId) {
        return ResponseEntity.ok(service.findByOrderId(orderId));
    }

    @GetMapping
    public ResponseEntity<List<DeliveryResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<DeliveryResponse> updateStatus(
            @PathVariable UUID id,
            @RequestBody UpdateDeliveryStatusRequest req) {
        return ResponseEntity.ok(service.updateStatus(id, req.getStatus()));
    }
}
