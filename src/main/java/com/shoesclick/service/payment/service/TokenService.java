package com.shoesclick.service.payment.service;

import com.shoesclick.service.payment.config.properties.TokenProperties;
import com.shoesclick.service.payment.entity.SsoToken;
import com.shoesclick.service.payment.mapper.TokenMapper;
import com.shoesclick.service.payment.repository.TokenRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final TokenRepository tokenRepository;

    private final TokenProperties tokenProperties;

    private final TokenMapper tokenMapper;

    private static final String CACHE_TOKEN = "cache_token_payment";

    public TokenService(TokenRepository tokenRepository, TokenProperties tokenProperties, TokenMapper tokenMapper) {
        this.tokenRepository = tokenRepository;
        this.tokenProperties = tokenProperties;
        this.tokenMapper = tokenMapper;
    }

    @Cacheable(value=CACHE_TOKEN, key = "#root.methodName")
    public SsoToken getToken(){
        return tokenRepository.getToken(tokenMapper.map(tokenProperties));
    }
}
