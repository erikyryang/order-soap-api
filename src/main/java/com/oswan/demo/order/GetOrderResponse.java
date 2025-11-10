package com.oswan.demo.order;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "GetOrderResponse", namespace = "http://example.com/orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetOrderResponse {
    private Long id;
    private String customerName;
    private double totalAmount;
    private String status;
}
