package com.estudo.java.rest.api.exceptions;


import com.estudo.java.rest.api.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
       log.info("Caiu no handler");

        ErrorMessage erro = new ErrorMessage(HttpStatus.BAD_GATEWAY.value(), "Erro ao processar sua solicitação");

        return new ResponseEntity(erro , HttpStatus.BAD_GATEWAY);
    }

}