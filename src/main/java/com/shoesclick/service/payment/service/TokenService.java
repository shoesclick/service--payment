package com.shoesclick.service.payment.service;

import com.shoesclick.service.payment.config.properties.TokenProperties;
import com.shoesclick.service.payment.entity.SsoToken;
import com.shoesclick.service.payment.repository.TokenRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final TokenRepository tokenRepository;

    private final TokenProperties tokenProperties;

    private static final String CACHE_TOKEN = "cache_token";

    public TokenService(TokenRepository tokenRepository, TokenProperties tokenProperties) {
        this.tokenRepository = tokenRepository;
        this.tokenProperties = tokenProperties;
    }

    @Cacheable(value=CACHE_TOKEN, key = "#root.methodName")
    public SsoToken getToken(){
        return tokenRepository.getToken(tokenProperties.grantType(), tokenProperties.clientId(),tokenProperties.clientSecret());
    }
}
