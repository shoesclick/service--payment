package com.shoesclick.service.payment.repository.gateway;


import com.shoesclick.service.payment.entity.gateway.DataBankSlip;
import com.shoesclick.service.payment.entity.gateway.StatusBankSlip;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "bankSlipTransactionClient", url = "${backend.gateway.bankSlipUrl}")
public interface BankSlipTransactionRepository {

    @RequestMapping(method = RequestMethod.POST, value = "/gateway/bank/slip/generate", produces = "application/json")
    StatusBankSlip generateSlip(DataBankSlip bankSlip);
}
