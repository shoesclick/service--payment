package com.shoesclick.service.payment.entity.gateway;

import java.math.BigDecimal;

public class DataBankSlip {

    private BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public DataBankSlip setValue(BigDecimal value) {
        this.value = value;
        return this;
    }
}
