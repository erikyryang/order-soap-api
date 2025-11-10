package com.oswan.demo.order;

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
@XmlRootElement(name = "GetOrderRequest", namespace = "http://example.com/orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetOrderRequest {
    @XmlElement(namespace = "http://example.com/orders")
    private Long id;
}
