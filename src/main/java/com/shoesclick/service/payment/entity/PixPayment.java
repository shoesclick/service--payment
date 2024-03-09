package com.shoesclick.service.payment.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PixPayment extends Payment {

    private String keyCode;

    public String getKeyCode() {
        return keyCode;
    }

    public PixPayment setKeyCode(String keyCode) {
        this.keyCode = keyCode;
        return this;
    }
}
