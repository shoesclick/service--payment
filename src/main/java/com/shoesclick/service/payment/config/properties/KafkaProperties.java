package com.shoesclick.service.payment.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kafka")
public record KafkaProperties(String bootstrapServers, String schemaRegistry, KafkaServiceProperties notification, KafkaServiceProperties payment) {}
