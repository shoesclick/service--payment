package com.shoesclick.service.payment.mock;

import com.shoesclick.service.payment.entity.gateway.StatusBankSlip;
import com.shoesclick.service.payment.entity.gateway.StatusCardTransaction;
import com.shoesclick.service.payment.entity.gateway.StatusPixKey;

import java.time.LocalDateTime;

public class StatusGatewayMock {

    private StatusGatewayMock() {
    }

    public static StatusPixKey getStatusPixKey() {
        return new StatusPixKey().setKeyCode("KEYCODE");
    }

    public static StatusBankSlip getStatusBankSlip() {
        return new StatusBankSlip().setCodeBar("KEYCODE");
    }

    public static StatusCardTransaction getStatusCardTransaction() {
        return new StatusCardTransaction().setTransactionId("TRANSACTION").setStatus("APPROVED").setTransactionDate(LocalDateTime.now());
    }
}
