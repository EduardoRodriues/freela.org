package br.com.carlosrodrigues.freela_org.core.exception;

import jakarta.persistence.EntityNotFoundException;

public class ServicoNaoEncontradoException extends EntityNotFoundException {

    public ServicoNaoEncontradoException(String menssage) {
        super(menssage);
    }
}
