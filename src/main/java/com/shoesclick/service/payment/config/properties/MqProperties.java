package com.shoesclick.service.payment.config.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rabbitmq")
public record MqProperties (String exchange, MQPaymentProperties payment, MQNotificationProperties notification) {}
