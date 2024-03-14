package com.shoesclick.service.payment.config.properties;

public record KafkaProperties(String bootstrapServers, String schemaRegistry, KafkaServiceProperties notification, KafkaServiceProperties payment) {}
