package com.shoesclick.service.payment.config;

import com.shoesclick.service.payment.config.properties.MqProperties;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    private final MqProperties mqProperties;

    public RabbitMQConfig(MqProperties mqProperties) {
        this.mqProperties = mqProperties;
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(mqProperties.getNotification().getQueue());
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(mqProperties.getExchange());
    }

    @Bean
    public Binding notificationBinding() {
        return BindingBuilder
                .bind(notificationQueue())
                .to(exchange())
                .with(mqProperties.getNotification().getRoutingKey());
    }

    @Bean
    public Queue paymentQueue() {
        return new Queue(mqProperties.getPayment().getQueue());
    }

    @Bean
    public Binding paymentBinding() {
        return BindingBuilder
                .bind(paymentQueue())
                .to(exchange())
                .with(mqProperties.getPayment().getRoutingKey());
    }
}
