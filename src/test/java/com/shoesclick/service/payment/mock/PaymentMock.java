package com.shoesclick.service.payment.mock;

import com.shoesclick.service.payment.entity.BankSlipPayment;
import com.shoesclick.service.payment.entity.CardPayment;
import com.shoesclick.service.payment.entity.PixPayment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentMock {

    private PaymentMock() {
    }

    public static PixPayment getPixPayment(){
        var pix = new PixPayment();
        pix.setValue(BigDecimal.ZERO);
        pix.setKeyCode("KEYCODE");
        return pix;
    }

    public static BankSlipPayment getBankSlipPayment(){
        var slip = new BankSlipPayment();
        slip.setCodeBar("CODEBAR");
        return slip;
    }

    public static CardPayment getCardPayment(){
        var card = new CardPayment();
        card.setStatus("APPROVED");
        card.setTransactionDate(LocalDateTime.now());
        card.setTransactionId("TRANSACTION_ID");
        return card;
    }
}
