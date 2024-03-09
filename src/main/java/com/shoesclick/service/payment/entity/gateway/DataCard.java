package com.shoesclick.service.payment.entity.gateway;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DataCard {

    private String number;

    private String name;

    private String code;

    private LocalDateTime expirationData;

    private BigDecimal value;

    public String getNumber() {
        return number;
    }

    public DataCard setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getName() {
        return name;
    }

    public DataCard setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public DataCard setCode(String code) {
        this.code = code;
        return this;
    }

    public LocalDateTime getExpirationData() {
        return expirationData;
    }

    public DataCard setExpirationData(LocalDateTime expirationData) {
        this.expirationData = expirationData;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public DataCard setValue(BigDecimal value) {
        this.value = value;
        return this;
    }
}
