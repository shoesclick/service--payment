package com.shoesclick.service.payment.config;

import com.shoesclick.service.payment.config.properties.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(KafkaProperties.class)
public class ServicePaymentConfig {
}
