package com.shoesclick.service.payment.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class CardPayment extends Payment {

    private String transactionId;

    private LocalDateTime transactionDate;

    private String status;

    private LocalDateTime expirationDate;

    public String getTransactionId() {
        return transactionId;
    }

    public CardPayment setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public CardPayment setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public CardPayment setStatus(String status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public CardPayment setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }
}
