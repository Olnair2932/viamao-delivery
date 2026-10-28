package com.viamao.delivery.delivery.service;

import com.viamao.delivery.delivery.domain.Delivery;
import com.viamao.delivery.delivery.domain.DeliveryStatus;
import com.viamao.delivery.delivery.dto.CreateDeliveryRequest;
import com.viamao.delivery.delivery.dto.DeliveryResponse;
import com.viamao.delivery.delivery.repository.DeliveryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DeliveryService {
    private final DeliveryRepository repository;

    public DeliveryService(DeliveryRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public DeliveryResponse create(CreateDeliveryRequest req) {
        Delivery d = new Delivery();
        d.setOrderId(req.getOrderId());
        d.setCourierName(req.getCourierName());
        d.setStatus(DeliveryStatus.PENDENTE);
        return DeliveryResponse.from(repository.save(d));
    }

    public DeliveryResponse findById(UUID id) {
        Delivery d = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Entrega não encontrada: " + id));
        return DeliveryResponse.from(d);
    }

    public DeliveryResponse findByOrderId(UUID orderId) {
        Delivery d = repository.findByOrderId(orderId)
            .orElseThrow(() -> new RuntimeException("Entrega não encontrada para o pedido: " + orderId));
        return DeliveryResponse.from(d);
    }

    public List<DeliveryResponse> findAll() {
        return repository.findAll().stream()
            .map(DeliveryResponse::from)
            .collect(Collectors.toList());
    }

    @Transactional
    public DeliveryResponse updateStatus(UUID id, DeliveryStatus status) {
        Delivery d = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Entrega não encontrada: " + id));
        d.setStatus(status);
        return DeliveryResponse.from(repository.save(d));
    }
}
