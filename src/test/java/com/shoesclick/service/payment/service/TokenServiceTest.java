package com.shoesclick.service.payment.service;

import com.shoesclick.service.payment.config.properties.TokenProperties;
import com.shoesclick.service.payment.entity.SsoToken;
import com.shoesclick.service.payment.mapper.TokenMapper;
import com.shoesclick.service.payment.repository.TokenRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.LinkedMultiValueMap;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class TokenServiceTest {

    @Mock
    private TokenRepository tokenRepository;

    @Mock
    private TokenProperties tokenProperties;

    @Mock
    private TokenMapper tokenMapper;

    @InjectMocks
    private TokenService tokenService;


    @BeforeEach
    void setup(){
        when(tokenProperties.clientId()).thenReturn("CLIENT-ID");
        when(tokenProperties.clientSecret()).thenReturn("CLIENT-SECRET");
        when(tokenProperties.grantType()).thenReturn("GRANT-TYPE");
    }

    @Test
    void shouldGetTokenSuccess(){
        when(tokenRepository.getToken(any())).thenReturn(new SsoToken());
        when(tokenMapper.map(any(TokenProperties.class))).thenReturn(new LinkedMultiValueMap<>());
        var token = tokenService.getToken();
        assertNotNull(token);
    }

    @Test
    void shouldGetTokenIsNull(){
        when(tokenRepository.getToken(any())).thenReturn(null);
        when(tokenMapper.map(any(TokenProperties.class))).thenReturn(new LinkedMultiValueMap<>());
        var token = tokenService.getToken();
        assertNull(token);
    }
}
