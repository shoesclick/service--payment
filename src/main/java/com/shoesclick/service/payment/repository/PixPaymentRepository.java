package com.shoesclick.service.payment.repository;

import com.shoesclick.service.payment.entity.PixPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PixPaymentRepository extends JpaRepository<PixPayment, Long> {
}
