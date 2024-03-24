package com.shoesclick.service.payment.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("cache.redis")
public record CacheProperties(String host, int port, int ttlCache) {}
