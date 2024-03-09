package com.shoesclick.service.payment.entity.gateway;

import java.time.LocalDateTime;

public class StatusCardTransaction {

    private String transactionId;

    private LocalDateTime transactionDate;

    private String status;

    public String getTransactionId() {
        return transactionId;
    }

    public StatusCardTransaction setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public StatusCardTransaction setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public StatusCardTransaction setStatus(String status) {
        this.status = status;
        return this;
    }
}
