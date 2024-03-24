package com.shoesclick.service.payment.repository;

import com.shoesclick.service.payment.entity.SsoToken;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "tokenClient", url = "${token.tokenUrl}")
public interface TokenRepository {

    @RequestMapping(method = RequestMethod.POST, value = "/protocol/openid-connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = "application/json")
    SsoToken getToken(@Param("grant_type") String grantType, @Param("client_id") String clientId, @Param("client_secret") String clientSecret);


}
