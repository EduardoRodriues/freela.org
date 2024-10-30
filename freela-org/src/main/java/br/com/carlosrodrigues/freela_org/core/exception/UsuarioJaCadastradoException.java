package br.com.carlosrodrigues.freela_org.core.exception;

import org.springframework.validation.FieldError;

import jakarta.persistence.EntityNotFoundException;

public class UsuarioJaCadastradoException extends EntityNotFoundException {
    
    public UsuarioJaCadastradoException(String mensagem, FieldError fieldError) {
        super(mensagem);
    }
}
