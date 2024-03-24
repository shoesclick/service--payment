package com.shoesclick.service.payment.service;

import com.shoesclick.notification.avro.NotificationAvro;
import com.shoesclick.service.payment.config.properties.KafkaProperties;
import com.shoesclick.service.payment.config.properties.KafkaServiceProperties;
import com.shoesclick.service.payment.entity.Notification;
import com.shoesclick.service.payment.enums.TypeTemplate;
import com.shoesclick.service.payment.mapper.NotificationMapper;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class NotificationServiceTest {

    @Mock
    private KafkaTemplate<String, NotificationAvro> kafkaTemplate;

    @Mock
    private KafkaProperties kafkaProperties;

    @Mock
    private NotificationMapper notificationMapper;

    @InjectMocks
    private NotificationService notificationService;
    @BeforeEach
    public void setUp() {
        var kafkaNotficationProperties = new KafkaServiceProperties("GROUPID","TOPIC");
        when(kafkaProperties.bootstrapServers()).thenReturn("SERVER");
        when(kafkaProperties.schemaRegistry()).thenReturn("REGISTRY");
        when(kafkaProperties.notification()).thenReturn(kafkaNotficationProperties);
    }

    @Test
    void shouldSendNotificationSuccess() throws IllegalAccessException {
        when(notificationMapper.map(any(Notification.class))).thenReturn(new NotificationAvro());
        notificationService.sendNotification(new Notification().setIdOrder(1L).setIdCustomer(1L).setTypeTemplate(TypeTemplate.CREATE_ORDER));
        verify(kafkaTemplate, times(1)).send(any(ProducerRecord.class));
    }
}
