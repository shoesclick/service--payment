package com.shoesclick.service.payment.domain;

import com.shoesclick.service.payment.entity.Order;

import java.util.Map;

public class PaymentDomain {

    private String paymentType;

    private Order order;

    private Map<String, Object> paymentParams;

    public String getPaymentType() {
        return paymentType;
    }

    public PaymentDomain setPaymentType(String paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public PaymentDomain setOrder(Order order) {
        this.order = order;
        return this;
    }

    public Map<String, Object> getPaymentParams() {
        return paymentParams;
    }

    public PaymentDomain setPaymentParams(Map<String, Object> paymentParams) {
        this.paymentParams = paymentParams;
        return this;
    }
}
