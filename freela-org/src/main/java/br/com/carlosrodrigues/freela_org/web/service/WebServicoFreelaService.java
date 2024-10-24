package br.com.carlosrodrigues.freela_org.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carlosrodrigues.freela_org.core.exception.ServicoNaoEncontradoException;
import br.com.carlosrodrigues.freela_org.core.models.ServicoFreela;
import br.com.carlosrodrigues.freela_org.core.repositories.ServicofreelaRepository;
import br.com.carlosrodrigues.freela_org.web.dtos.ServicoFreelaForm;
import br.com.carlosrodrigues.freela_org.web.mappers.WebServicoFreelaMapper;

@Service
public class WebServicoFreelaService {
    
    @Autowired
    private WebServicoFreelaMapper mapper;

    @Autowired
    private ServicofreelaRepository repository;

    public List<ServicoFreela> buscarTodos() {

        return repository.findAll();
    }

    public ServicoFreela cadastrar(ServicoFreelaForm form) {

        var model = mapper.toModel(form);
        return repository.save(model);
    }

    public ServicoFreela buscarPorId(Long id) {

        var mensagem = String.format("Serviço não encontrado", id);

        return repository.findById(id)
        .orElseThrow(() -> new ServicoNaoEncontradoException(mensagem));
    }

    public ServicoFreela editar(ServicoFreelaForm form, Long id) {

        var servicoEncontrado = buscarPorId(id);

        var model = mapper.toModel(form);
        model.setId(servicoEncontrado.getId());

        return repository.save(model);
    }

    public void excluir(Long id) {

        var servicoEncontrado = buscarPorId(id);

        repository.delete(servicoEncontrado);
    }

}
