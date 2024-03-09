package com.shoesclick.service.payment.entity;

import jakarta.persistence.Entity;

@Entity
public class BankSlipPayment extends Payment {

    private String codeBar;

    public String getCodeBar() {
        return codeBar;
    }

    public BankSlipPayment setCodeBar(String codeBar) {
        this.codeBar = codeBar;
        return this;
    }
}
