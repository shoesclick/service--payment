package com.shoesclick.service.payment.service;

import com.shoesclick.service.payment.aspect.InjectLogger;
import com.shoesclick.service.payment.domain.PaymentDomain;
import com.shoesclick.service.payment.entity.Notification;
import com.shoesclick.service.payment.entity.Order;
import com.shoesclick.service.payment.entity.OrderStatus;
import com.shoesclick.service.payment.enums.TypeTemplate;
import com.shoesclick.service.payment.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final Integer PAYMENT_PROCESS = 2;

    private final ProcessPaymentService processPaymentService;

    private final NotificationService notificationService;

    private final OrderRepository orderRepository;

    public PaymentService(ProcessPaymentService processPaymentService, NotificationService notificationService, OrderRepository orderRepository) {
        this.processPaymentService = processPaymentService;
        this.notificationService = notificationService;
        this.orderRepository = orderRepository;
    }


    @Transactional
    @InjectLogger
    public void process(PaymentDomain paymentDomain) {
        processPaymentService.savePayment(paymentDomain);
        orderRepository.updateStatus(paymentDomain.getOrder().getId(), new OrderStatus().setStatus(PAYMENT_PROCESS));
        notificationService.sendNotification(getNotification(paymentDomain.getOrder()));
    }




    private Notification getNotification(Order order) {
        return new Notification()
                .setIdOrder(order.getId())
                .setTypeTemplate(TypeTemplate.PAYMENT_APPROVED)
                .setIdCustomer(order.getIdCustomer());
    }
}
