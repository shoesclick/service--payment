package com.shoesclick.service.payment.entity.gateway;

public class StatusBankSlip {

    private String base64;

    private String codeBar;

    public String getBase64() {
        return base64;
    }

    public StatusBankSlip setBase64(String base64) {
        this.base64 = base64;
        return this;
    }

    public String getCodeBar() {
        return codeBar;
    }

    public StatusBankSlip setCodeBar(String codeBar) {
        this.codeBar = codeBar;
        return this;
    }
}
