package com.shoesclick.service.payment.service;


import com.shoesclick.service.payment.domain.PaymentDomain;
import com.shoesclick.service.payment.entity.gateway.DataBankSlip;
import com.shoesclick.service.payment.entity.gateway.DataCard;
import com.shoesclick.service.payment.entity.gateway.DataPix;
import com.shoesclick.service.payment.mapper.PaymentMapper;
import com.shoesclick.service.payment.repository.BankSlipPaymentRepository;
import com.shoesclick.service.payment.repository.CardPaymentRepository;
import com.shoesclick.service.payment.repository.PixPaymentRepository;
import com.shoesclick.service.payment.repository.gateway.BankSlipTransactionRepository;
import com.shoesclick.service.payment.repository.gateway.CardTransactionRepository;
import com.shoesclick.service.payment.repository.gateway.PixTransactionRepository;
import com.shoesclick.service.payment.strategy.PaymentStrategy;
import org.springframework.stereotype.Service;

@Service
public class ProcessPaymentService {

    private final CardPaymentRepository cardPaymentRepository;

    private final PixPaymentRepository pixPaymentRepository;

    private final BankSlipPaymentRepository bankSlipPaymentRepository;

    private final CardTransactionRepository cardTransactionRepository;

    private final PixTransactionRepository pixTransactionRepository;

    private final BankSlipTransactionRepository bankSlipTransactionRepository;

    private final PaymentMapper paymentMapper;

    public ProcessPaymentService(CardPaymentRepository cardPaymentRepository, PixPaymentRepository pixPaymentRepository, BankSlipPaymentRepository bankSlipPaymentRepository, CardTransactionRepository cardTransactionRepository, PixTransactionRepository pixTransactionRepository, BankSlipTransactionRepository bankSlipTransactionRepository, PaymentMapper paymentMapper) {
        this.cardPaymentRepository = cardPaymentRepository;
        this.pixPaymentRepository = pixPaymentRepository;
        this.bankSlipPaymentRepository = bankSlipPaymentRepository;
        this.cardTransactionRepository = cardTransactionRepository;
        this.pixTransactionRepository = pixTransactionRepository;
        this.bankSlipTransactionRepository = bankSlipTransactionRepository;
        this.paymentMapper = paymentMapper;
    }


    public void savePayment(PaymentDomain paymentDomain) {

        var paymentStrategy = PaymentStrategy.findByName(paymentDomain.getPaymentType());
        switch (paymentStrategy) {
            case PIX_PAYMENT -> {
                DataPix params = paymentStrategy.convert(paymentDomain.getPaymentParams());
                var status = pixTransactionRepository.generatePix(params);
                pixPaymentRepository.save(paymentMapper.map(status,paymentDomain.getOrder(), params.getValue()));
            }
            case CARD_PAYMENT -> {
                DataCard params = paymentStrategy.convert(paymentDomain.getPaymentParams());
                var status = cardTransactionRepository.transactionCard(params);
                cardPaymentRepository.save(paymentMapper.map(status,paymentDomain.getOrder(), params.getValue()));
            }
            case BANKSLIP_PAYMENT ->{
                DataBankSlip params = paymentStrategy.convert(paymentDomain.getPaymentParams());
               var status = bankSlipTransactionRepository.generateSlip(params);
               bankSlipPaymentRepository.save(paymentMapper.map(status,paymentDomain.getOrder(), params.getValue()));
            }
         }
    }
}
