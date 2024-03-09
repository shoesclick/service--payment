package com.shoesclick.service.payment.service;

import com.shoesclick.service.payment.domain.PaymentDomain;
import com.shoesclick.service.payment.entity.*;
import com.shoesclick.service.payment.repository.CardPaymentRepository;
import com.shoesclick.service.payment.repository.OrderRepository;
import com.shoesclick.service.payment.repository.PixPaymentRepository;
import com.shoesclick.service.payment.repository.BankSlipPaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.shoesclick.service.payment.mock.OrderMock.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class PaymentServiceTest extends AbstractServiceTest {


    @Mock
    private ProcessPaymentService processPaymentService;

    @Mock
    private NotificationService notificationService;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private PaymentService paymentService;

    @BeforeEach
    void setup() {
        paymentService = setupServiceTest(paymentService);
    }


    @Test
    void shouldProcessPaymentSuccess(){
        paymentService.process(getPaymentDomain());
        verify(processPaymentService, times(1)).savePayment(any(PaymentDomain.class));
        verify(orderRepository,times(1)).updateStatus(anyLong(), any(OrderStatus.class));
        verify(notificationService, times(1)).sendNotification(any(Notification.class));
    }


}
