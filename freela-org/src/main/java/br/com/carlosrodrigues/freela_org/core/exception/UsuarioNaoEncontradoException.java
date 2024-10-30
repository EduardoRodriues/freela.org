package br.com.carlosrodrigues.freela_org.core.exception;

import jakarta.persistence.EntityNotFoundException;

public class UsuarioNaoEncontradoException extends EntityNotFoundException {
    
    public UsuarioNaoEncontradoException(String menssage) {
        super(menssage);
    }
}
