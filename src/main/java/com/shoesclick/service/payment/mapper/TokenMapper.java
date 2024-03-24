package com.shoesclick.service.payment.mapper;

import com.shoesclick.service.payment.config.properties.TokenProperties;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Mapper(componentModel= MappingConstants.ComponentModel.SPRING)
public interface TokenMapper {

    default MultiValueMap<String, String> map(TokenProperties token){
        MultiValueMap<String,String> map = new  LinkedMultiValueMap<>();
        map.add("client_id",token.clientId());
        map.add("client_secret",token.clientSecret());
        map.add("grant_type",token.grantType());
        return map;
    }
}
