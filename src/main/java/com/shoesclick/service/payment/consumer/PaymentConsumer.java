package com.shoesclick.service.payment.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shoesclick.payment.avro.PaymentAvro;
import com.shoesclick.service.payment.config.properties.KafkaProperties;
import com.shoesclick.service.payment.exception.BusinessException;
import com.shoesclick.service.payment.mapper.PaymentMapper;
import com.shoesclick.service.payment.service.PaymentService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
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


    @KafkaListener(topics = "notification-topic", groupId = "group-1")
    @RetryableTopic(
            backoff = @Backoff(value = 3000L),
            attempts = "5",
            autoCreateTopics = "true",
            include = BusinessException.class
    )
    public void process(PaymentAvro message) throws JsonProcessingException {
        paymentService.process(paymentMapper.map(message));
    }
}
