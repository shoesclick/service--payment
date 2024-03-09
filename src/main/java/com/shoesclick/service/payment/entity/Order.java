package com.shoesclick.service.payment.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Order {

    private Long id;

    private Integer status = 1;

    private Long idCustomer;

    private LocalDateTime createdAt;

    private Set<OrderItem> orderItems = new HashSet<>();


    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Order setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public Order setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Order setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Order setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
        return this;
    }
}
