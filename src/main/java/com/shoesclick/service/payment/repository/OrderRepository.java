package com.shoesclick.service.payment.repository;


import com.shoesclick.service.payment.entity.OrderStatus;
import com.shoesclick.service.payment.entity.Status;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "orderClient", url = "${backend.services.orderUrl}")
public interface OrderRepository {

    @RequestMapping(method = RequestMethod.POST, value = "/api/order/{id}/status", produces = "application/json")
    Status updateStatus(@PathVariable("id") Long id, OrderStatus orderStatus);

}
