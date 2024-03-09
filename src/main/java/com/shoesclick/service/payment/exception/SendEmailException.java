package com.shoesclick.service.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class SendEmailException extends ResourceException {

    /**
     * Serial id
     */
    private static final long serialVersionUID = 320544027441912540L;

    /**
     * Construtor com parametros
     *
     * @param message Mensagem
     *
     * @param cause Objeto de exceção
     *
     */
    public SendEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construtor com parametros
     *
     * @param message Mensagem
     */
    public SendEmailException(String message) {
        super(message);
    }

}