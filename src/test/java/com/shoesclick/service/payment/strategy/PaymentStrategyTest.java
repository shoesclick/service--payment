package com.shoesclick.service.payment.strategy;

import com.shoesclick.service.payment.exception.ElementNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
class PaymentStrategyTest {


    @Test
    void shouldReturn_PIX_PAYMENT_findByName() {
        assertEquals(PaymentStrategy.PIX_PAYMENT, PaymentStrategy.findByName("PIX_PAYMENT"));
    }

    @Test
    void shouldReturn_CARD_PAYMENT_findByName() {
        assertEquals(PaymentStrategy.CARD_PAYMENT, PaymentStrategy.findByName("CARD_PAYMENT"));
    }

    @Test
    void shouldReturn_BANKSLIP_PAYMENT_findByName() {
        assertEquals(PaymentStrategy.BANKSLIP_PAYMENT, PaymentStrategy.findByName("BANKSLIP_PAYMENT"));
    }

    @Test
    void shouldThrowsElementNotFoundException_findByNameIsInvalid() {
        assertThrows(ElementNotFoundException.class, () -> PaymentStrategy.findByName("INVALID"));
    }
}