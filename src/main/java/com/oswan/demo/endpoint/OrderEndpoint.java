package com.oswan.demo.endpoint;

import com.oswan.demo.order.*;
import com.oswan.demo.order.request.CreateOrderRequest;
import com.oswan.demo.order.request.GetOrderRequest;
import com.oswan.demo.order.response.CreateOrderResponse;
import com.oswan.demo.order.response.GetOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class OrderEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/orders";
    private final OrderService orderService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateOrderRequest")
    @ResponsePayload
    public CreateOrderResponse createOrder(@RequestPayload CreateOrderRequest request) {
        return orderService.createOrder(request.getCustomerName(), request.getTotalAmount());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetOrderRequest")
    @ResponsePayload
    public GetOrderResponse getOrder(@RequestPayload GetOrderRequest request) {
        return orderService.findById(request.getId());
    }
}
