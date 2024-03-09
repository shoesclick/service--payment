package com.shoesclick.service.payment.strategy;

import com.shoesclick.service.payment.entity.gateway.DataBankSlip;
import com.shoesclick.service.payment.entity.gateway.DataCard;
import com.shoesclick.service.payment.entity.gateway.DataPix;
import com.shoesclick.service.payment.exception.ElementNotFoundException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

public enum PaymentStrategy {
    PIX_PAYMENT {
        @Override
        public DataPix convert(Map paymentParams) {
            var payment = new DataPix();
            payment.setValue( new BigDecimal(String.valueOf(paymentParams.get("value"))));
            return payment;
        }
    },
    CARD_PAYMENT {
        @Override
        public DataCard convert(Map paymentParams) {
            var payment = new DataCard();
            payment.setValue( new BigDecimal(String.valueOf(paymentParams.get("value"))));
            payment.setNumber(String.valueOf(paymentParams.get("number")));
            payment.setName(String.valueOf(paymentParams.get("name")));
            payment.setCode(String.valueOf(paymentParams.get("code")));
            payment.setExpirationData(LocalDateTime.parse(String.valueOf(paymentParams.get("expirationDate"))));
            return payment;
        }
    },

    BANKSLIP_PAYMENT {
        @Override
        public DataBankSlip convert(Map paymentParams) {
            var payment = new DataBankSlip();
            payment.setValue( new BigDecimal(String.valueOf(paymentParams.get("value"))));
            return payment;


        }
    };

    public abstract <P> P convert(Map<String,Object> campos);


    public static PaymentStrategy findByName(String name){
        return Arrays.stream(PaymentStrategy.values()).filter( item -> item.name().equals(name)).findFirst().orElseThrow( ()-> new ElementNotFoundException("ELEMENTO NÃO ENCONTRADO"));
    }


}
