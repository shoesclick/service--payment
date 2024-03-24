package com.shoesclick.service.payment.config;

import com.shoesclick.service.payment.config.properties.CacheProperties;
import com.shoesclick.service.payment.config.properties.KafkaProperties;
import com.shoesclick.service.payment.config.properties.TokenProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({KafkaProperties.class, CacheProperties.class, TokenProperties.class})
public class ServicePaymentConfig {
}
