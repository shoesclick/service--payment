package com.shoesclick.service.payment.repository;

import com.shoesclick.service.payment.entity.BankSlipPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankSlipPaymentRepository extends JpaRepository<BankSlipPayment, Long> {
}
