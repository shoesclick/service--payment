package com.shoesclick.service.payment.service;

import com.shoesclick.service.payment.aspect.InjectLogger;
import com.shoesclick.service.payment.entity.BankSlipPayment;
import com.shoesclick.service.payment.entity.CardPayment;
import com.shoesclick.service.payment.entity.Order;
import com.shoesclick.service.payment.entity.PixPayment;
import com.shoesclick.service.payment.entity.gateway.*;
import com.shoesclick.service.payment.mapper.PaymentMapper;
import com.shoesclick.service.payment.repository.BankSlipPaymentRepository;
import com.shoesclick.service.payment.repository.CardPaymentRepository;
import com.shoesclick.service.payment.repository.PixPaymentRepository;
import com.shoesclick.service.payment.repository.gateway.BankSlipTransactionRepository;
import com.shoesclick.service.payment.repository.gateway.CardTransactionRepository;
import com.shoesclick.service.payment.repository.gateway.PixTransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.shoesclick.service.payment.mock.OrderMock.*;
import static com.shoesclick.service.payment.mock.PaymentMock.*;
import static com.shoesclick.service.payment.mock.StatusGatewayMock.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ProcessPaymentServiceTest {

    @Mock
    private CardPaymentRepository cardPaymentRepository;

    @Mock
    private PixPaymentRepository pixPaymentRepository;

    @Mock
    private BankSlipPaymentRepository bankSlipPaymentRepository;

    @Mock
    private CardTransactionRepository cardTransactionRepository;

    @Mock
    private PixTransactionRepository pixTransactionRepository;

    @Mock
    private BankSlipTransactionRepository bankSlipTransactionRepository;

    @Mock
    private PaymentMapper paymentMapper;

    @InjectMocks
    private ProcessPaymentService processPaymentService;


    @Test
    void shouldProcessPayment_PIX_PAYMENT_Success() {
        when(pixTransactionRepository.generatePix(any(DataPix.class))).thenReturn(getStatusPixKey());
        when(paymentMapper.map(any(StatusPixKey.class), any(Order.class), any(BigDecimal.class))).thenReturn(getPixPayment());
        processPaymentService.savePayment(getPaymentDomain_PIX_PAYMENT());
        verify(pixPaymentRepository, times(1)).save(any(PixPayment.class));
    }
    @Test
    void shouldProcessPayment_BANKSLIP_PAYMENT_Success() {
        when(bankSlipTransactionRepository.generateSlip(any(DataBankSlip.class))).thenReturn(getStatusBankSlip());
        when(paymentMapper.map(any(StatusBankSlip.class), any(Order.class), any(BigDecimal.class))).thenReturn(getBankSlipPayment());
        processPaymentService.savePayment(getPaymentDomain_BANKSLIP_PAYMENT());
        verify(bankSlipPaymentRepository, times(1)).save(any(BankSlipPayment.class));
    }

    @Test
    void shouldProcessPayment_CARD_PAYMENT_Success() {
        when(cardTransactionRepository.transactionCard(any(DataCard.class))).thenReturn(getStatusCardTransaction());
        when(paymentMapper.map(any(StatusCardTransaction.class), any(Order.class), any(BigDecimal.class))).thenReturn(getCardPayment());
        processPaymentService.savePayment(getPaymentDomain_CARD_PAYMENT());
        verify(cardPaymentRepository, times(1)).save(any(CardPayment.class));
    }
}
