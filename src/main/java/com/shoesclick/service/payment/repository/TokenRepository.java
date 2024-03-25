package com.shoesclick.service.payment.repository;

import com.shoesclick.service.payment.entity.SsoToken;
import feign.Headers;
import feign.Logger;
import feign.codec.Encoder;
import feign.form.FormEncoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(value = "tokenClient", url = "${token.tokenUrl}", configuration = TokenRepository.FeignConverterConfiguration.class)
public interface TokenRepository {

    @RequestMapping(method = RequestMethod.POST, value = "/protocol/openid-connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    SsoToken getToken(@RequestBody Map<String, ?> formToken);

    class FeignConverterConfiguration {

        @Bean
        Encoder feignFormEncoder(ObjectFactory<HttpMessageConverters> converters) {
            return new SpringFormEncoder(new SpringEncoder(converters));
        }

        @Bean
        Logger.Level feignLoggerLevel() {
            return Logger.Level.BASIC;
        }
    }


}
