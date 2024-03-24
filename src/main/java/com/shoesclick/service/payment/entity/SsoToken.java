package com.shoesclick.service.payment.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.Serial;
import java.io.Serializable;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SsoToken implements Serializable {

    @Serial
    private static final long serialVersionUID = 6290268352746685066L;
    private String accesToken;

    private String expiresIn;

    private String tokenType;

    public String getAccesToken() {
        return accesToken;
    }

    public SsoToken setAccesToken(String accesToken) {
        this.accesToken = accesToken;
        return this;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public SsoToken setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    public String getTokenType() {
        return tokenType;
    }

    public SsoToken setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }
}
