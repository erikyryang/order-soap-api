package com.oswan.demo.order.response;

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
@XmlRootElement(name = "CreateOrderResponse", namespace = "http://example.com/orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateOrderResponse {
    @XmlElement(namespace = "http://example.com/orders")
    private Long orderId;
}
