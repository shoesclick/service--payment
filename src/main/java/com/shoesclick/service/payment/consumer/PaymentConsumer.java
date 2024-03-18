package com.shoesclick.service.payment.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shoesclick.payment.avro.PaymentAvro;
import com.shoesclick.service.payment.config.properties.KafkaProperties;
import com.shoesclick.service.payment.mapper.PaymentMapper;
import com.shoesclick.service.payment.service.PaymentService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {


    private final KafkaProperties kafkaProperties;

    private final PaymentService paymentService;

    private final PaymentMapper paymentMapper;

    public PaymentConsumer(KafkaProperties kafkaProperties, PaymentService paymentService, PaymentMapper paymentMapper) {
        this.kafkaProperties = kafkaProperties;
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
    }


    @KafkaListener(topics = "kfk-order-payment", groupId = "grp-order-payment")
    public void process(@Payload PaymentAvro message, @Header(name = KafkaHeaders.RECEIVED_KEY) String key) throws JsonProcessingException {
        System.out.println("CHAVE: "+ key);
        paymentService.process(paymentMapper.map(message));
    }
}
