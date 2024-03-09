package com.shoesclick.service.payment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.shoesclick.service.payment.config.properties.MqProperties;
import com.shoesclick.service.payment.entity.Notification;
import com.shoesclick.service.payment.entity.Order;
import com.shoesclick.service.payment.enums.TypeTemplate;
import com.shoesclick.service.payment.exception.BusinessException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class NotificationService {


    private final MqProperties mqProperties;
    private final AmqpTemplate rabbitTemplate;

    public NotificationService(MqProperties mqProperties, AmqpTemplate rabbitTemplate) {
        this.mqProperties = mqProperties;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendNotification(Notification notification) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            String json = mapper.writeValueAsString(notification);
            rabbitTemplate.convertAndSend(mqProperties.getExchange(), mqProperties.getNotification().getRoutingKey(), json);
        } catch (JsonProcessingException e) {
            throw new BusinessException("ERRO NO PROCESSAMENTO DA FILA MQ");
        }
    }

}
