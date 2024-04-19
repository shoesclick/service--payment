package com.shoesclick.service.payment.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class PaymentMetrics {

    private final Counter paymentProcess;

    private final Counter paymentErrors;

    public PaymentMetrics(MeterRegistry registry) {
        this.paymentProcess = Counter.builder("payment_process_total")
                .description("Total de Pagamentos Processados")
                .register(registry);

        this.paymentErrors = Counter.builder("payment_process_errors_total")
                .description("Total de Pagamentos Com erros")
                .register(registry);

    }

    public void incrementPaymentSuccessCount() {
        paymentErrors.increment();
    }

    public void incrementPaymentErrorCount() {
        paymentErrors.increment();
    }
}
