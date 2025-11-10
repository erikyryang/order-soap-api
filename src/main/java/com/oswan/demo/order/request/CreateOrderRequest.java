package com.oswan.demo.order.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "CreateOrderRequest", namespace = "http://example.com/orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateOrderRequest {
    @XmlElement(namespace = "http://example.com/orders")
    private String customerName;
    @XmlElement(namespace = "http://example.com/orders")
    private double totalAmount;
}