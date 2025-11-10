package com.oswan.demo.order;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderConsumer {

    private final OrderService orderService;

    @KafkaListener(topics = {"order-created"}, groupId = "order-group")
    public void listen(String message) {
        Long orderId = Long.valueOf(message);
        orderService.updateStatus(orderId, "RECEIVED");
    }
}