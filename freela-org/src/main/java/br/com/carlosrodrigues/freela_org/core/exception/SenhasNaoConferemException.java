package br.com.carlosrodrigues.freela_org.core.exception;

import org.springframework.validation.FieldError;

import jakarta.persistence.EntityNotFoundException;

public class SenhasNaoConferemException extends EntityNotFoundException {

    public SenhasNaoConferemException(String mensagem, FieldError fieldError) {
        super(mensagem);
    }
}
