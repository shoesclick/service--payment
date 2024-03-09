package com.shoesclick.service.payment.service;

import com.shoesclick.service.payment.config.properties.MQNotificationProperties;
import com.shoesclick.service.payment.config.properties.MqProperties;
import com.shoesclick.service.payment.entity.Notification;
import com.shoesclick.service.payment.enums.TypeTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class NotificationServiceTest {

    @Mock
    private MqProperties mqProperties;

    @Mock
    private AmqpTemplate rabbitTemplate;

    @InjectMocks
    private NotificationService notificationService;

    @BeforeEach
    public void setUp() {
        var mqNotificationProperties = new MQNotificationProperties();
        mqNotificationProperties.setQueue("FILA");
        mqNotificationProperties.setRoutingKey("ROUTING");
        when(mqProperties.getExchange()).thenReturn("EXCHANGE");
        when(mqProperties.getNotification()).thenReturn(mqNotificationProperties);
    }

    @Test
    void shouldSendNotificationSuccess() throws IllegalAccessException {
        notificationService.sendNotification(new Notification().setIdOrder(1L).setIdCustomer(1L).setTypeTemplate(TypeTemplate.PAYMENT_APPROVED));
        verify(rabbitTemplate, times(1)).convertAndSend(anyString(), anyString(), anyString());
    }
}
