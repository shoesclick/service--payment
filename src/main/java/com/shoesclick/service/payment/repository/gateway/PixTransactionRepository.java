package com.shoesclick.service.payment.repository.gateway;


import com.shoesclick.service.payment.entity.gateway.DataPix;
import com.shoesclick.service.payment.entity.gateway.StatusPixKey;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "pixTransactionClient", url = "${backend.gateway.pixUrl}")
public interface PixTransactionRepository {

    @RequestMapping(method = RequestMethod.POST, value = "/gateway/pix/generate", produces = "application/json")
    StatusPixKey generatePix (DataPix dataPix);
}
