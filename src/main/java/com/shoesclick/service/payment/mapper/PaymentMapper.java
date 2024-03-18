package com.shoesclick.service.payment.mapper;


import com.shoesclick.payment.avro.PaymentAvro;
import com.shoesclick.service.payment.domain.PaymentDomain;
import com.shoesclick.service.payment.entity.*;
import com.shoesclick.service.payment.entity.gateway.StatusBankSlip;
import com.shoesclick.service.payment.entity.gateway.StatusCardTransaction;
import com.shoesclick.service.payment.entity.gateway.StatusPixKey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.math.BigDecimal;

@Mapper(componentModel= MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {

    @Mapping(target = "keyCode", source = "response.keyCode")
    @Mapping(target = "idOrder", source = "order.id")
    @Mapping(target = "idCustomer", source = "order.idCustomer")
    @Mapping(target = "value", source = "valuePayment")
    PixPayment map(StatusPixKey response, Order order, BigDecimal valuePayment);

    @Mapping(target = "transactionId", source = "response.transactionId")
    @Mapping(target = "transactionDate", source = "response.transactionDate")
    @Mapping(target = "status", source = "response.status")
    @Mapping(target = "idOrder", source = "order.id")
    @Mapping(target = "idCustomer", source = "order.idCustomer")
    @Mapping(target = "value", source = "valuePayment")
    CardPayment map(StatusCardTransaction response, Order order, BigDecimal valuePayment);

    @Mapping(target = "codeBar", source = "response.codeBar")
    @Mapping(target = "idOrder", source = "order.id")
    @Mapping(target = "idCustomer", source = "order.idCustomer")
    @Mapping(target = "value", source = "valuePayment")
    BankSlipPayment map(StatusBankSlip response, Order order, BigDecimal valuePayment);

    PaymentDomain map(PaymentAvro paymentAvro);
}
