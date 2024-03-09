package com.shoesclick.service.payment.repository.gateway;


import com.shoesclick.service.payment.entity.gateway.DataCard;
import com.shoesclick.service.payment.entity.gateway.StatusCardTransaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "cardTransactionClient", url = "${backend.gateway.cardUrl}")
public interface CardTransactionRepository {

    @RequestMapping(method = RequestMethod.POST, value = "/gateway/card/transaction", produces = "application/json")
    StatusCardTransaction transactionCard(DataCard dataCard);
}
