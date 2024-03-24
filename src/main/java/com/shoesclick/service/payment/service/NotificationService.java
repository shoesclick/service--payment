package com.shoesclick.service.payment.service;

import com.shoesclick.notification.avro.NotificationAvro;
import com.shoesclick.service.payment.config.properties.KafkaProperties;
import com.shoesclick.service.payment.entity.Notification;
import com.shoesclick.service.payment.mapper.NotificationMapper;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class NotificationService {


    private final KafkaTemplate<String, NotificationAvro> kafkaTemplate;

    private final KafkaProperties kafkaProperties;

    private final NotificationMapper notificationMapper;

    public NotificationService(KafkaTemplate<String, NotificationAvro> kafkaTemplate, KafkaProperties kafkaProperties, NotificationMapper notificationMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaProperties = kafkaProperties;
        this.notificationMapper = notificationMapper;
    }

    public void sendNotification(Notification notification) {
        var record = new ProducerRecord<>(kafkaProperties.notification().topic(), String.valueOf(notification.getIdOrder()), notificationMapper.map(notification));
        kafkaTemplate.send(record);
    }

}
