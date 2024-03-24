package com.shoesclick.service.payment.repository;

import com.shoesclick.service.payment.entity.SsoToken;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(value = "tokenClient", url = "${token.tokenUrl}")
public interface TokenRepository {

    @RequestMapping(method = RequestMethod.POST, value = "/protocol/openid-connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = "application/json")
    SsoToken getToken(@RequestBody MultiValueMap<String, String> formToken);


}
