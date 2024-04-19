package com.shoesclick.service.payment.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shoesclick.payment.avro.PaymentAvro;
import com.shoesclick.service.payment.config.MetricsConfig;
import com.shoesclick.service.payment.config.PaymentMetrics;
import com.shoesclick.service.payment.config.properties.KafkaProperties;
import com.shoesclick.service.payment.mapper.PaymentMapper;
import com.shoesclick.service.payment.service.PaymentService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {


    private final KafkaProperties kafkaProperties;

    private final PaymentService paymentService;

    private final PaymentMapper paymentMapper;

    private final PaymentMetrics paymentMetrics;

    public PaymentConsumer(KafkaProperties kafkaProperties, PaymentService paymentService, PaymentMapper paymentMapper, PaymentMetrics paymentMetrics) {
        this.kafkaProperties = kafkaProperties;
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
        this.paymentMetrics = paymentMetrics;
    }


    @KafkaListener(topics = "kfk-order-payment", groupId = "grp-order-payment")
    public void process(@Payload PaymentAvro message, @Header(name = KafkaHeaders.RECEIVED_KEY) String key, @Headers MessageHeaders headers) throws JsonProcessingException {
        System.out.println("KEY:"+ key);
        paymentService.process(paymentMapper.map(message));
        paymentMetrics.incrementPaymentSuccessCount();
    }
}
