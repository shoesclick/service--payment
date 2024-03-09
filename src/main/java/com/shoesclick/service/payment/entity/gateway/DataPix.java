package com.shoesclick.service.payment.entity.gateway;

import java.math.BigDecimal;

public class DataPix {

    private BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public DataPix setValue(BigDecimal value) {
        this.value = value;
        return this;
    }
}
