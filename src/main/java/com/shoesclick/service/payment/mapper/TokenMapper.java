package com.shoesclick.service.payment.mapper;

import com.shoesclick.service.payment.config.properties.TokenProperties;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.HashMap;
import java.util.Map;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TokenMapper {

    default Map<String, ?> map(TokenProperties token) {
        Map<String, String> map = new HashMap<>();
        map.put("client_id", token.clientId());
        map.put("client_secret", token.clientSecret());
        map.put("grant_type", token.grantType());
        return map;
    }
}
