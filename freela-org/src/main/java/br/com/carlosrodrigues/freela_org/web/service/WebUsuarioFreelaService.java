package br.com.carlosrodrigues.freela_org.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import br.com.carlosrodrigues.freela_org.core.enums.TipoUsuario;
import br.com.carlosrodrigues.freela_org.core.exception.SenhasNaoConferemException;
import br.com.carlosrodrigues.freela_org.core.exception.UsuarioJaCadastradoException;
import br.com.carlosrodrigues.freela_org.core.exception.UsuarioNaoEncontradoException;
import br.com.carlosrodrigues.freela_org.core.models.UsuarioFreela;
import br.com.carlosrodrigues.freela_org.core.repositories.UsuarioFreelaRepository;
import br.com.carlosrodrigues.freela_org.web.dtos.UsuarioFreelaCadastroForm;
import br.com.carlosrodrigues.freela_org.web.dtos.UsuarioFreelaEdicaoForm;
import br.com.carlosrodrigues.freela_org.web.mappers.WebUsuarioFreelaMapper;

@Service
public class WebUsuarioFreelaService {
    
    @Autowired
    private WebUsuarioFreelaMapper mapper;

    @Autowired
    private UsuarioFreelaRepository repository;


    public List<UsuarioFreela> mostrarTodos() {

        return repository.findAll();
    }

    public UsuarioFreela cadastrar(UsuarioFreelaCadastroForm form) {


        var senha = form.getSenha();
        var confirmacaoSenha = form.getConfirmacaoSenha();

        if(!senha.equals(confirmacaoSenha)) {
            var mensagem = "Os campos não conferem";

            var fieldError = new FieldError(form.getClass().getName(),
             "as senhas não conferem",
             form.getConfirmacaoSenha(),
            false,
            null,
            null,
            mensagem);

            throw new SenhasNaoConferemException(mensagem, fieldError);
        }

        var model = mapper.toModel(form);

        var passwordEncoder = new BCryptPasswordEncoder();
        var senhaHash = passwordEncoder.encode(model.getSenha());

        model.setSenha(senhaHash);
        model.setTipoUsuario(TipoUsuario.ADMIN);
        
        validarCamposUnicos(model);
        return repository.save(model);
    }

    public UsuarioFreela buscarPorId(Long id) {

        var mensagem = String.format("O usuario não foi encontrado", id);

        return repository.findById(id)
        .orElseThrow(() -> new UsuarioNaoEncontradoException(mensagem));
    }

    public UsuarioFreela editar(UsuarioFreelaEdicaoForm form, Long id) {
        var usuario = buscarPorId(id);

        var model = mapper.toModel(form);

        model.setId(usuario.getId());
        model.setSenha(usuario.getSenha());
        model.setTipoUsuario(usuario.getTipoUsuario());

        return repository.save(model);
    }

    public void excluir(Long id) {
        var usuario = buscarPorId(id);

        repository.delete(usuario);
    }

    private void validarCamposUnicos(UsuarioFreela usuario) {

        if(repository.isEmailJaCadastrado(usuario.getEmail(), usuario.getId())) {
            var menssagem = "este email já foi cadastrado";

            var fieldError = new FieldError(usuario.getClass().getName(),
             "email", usuario.getEmail(),
              false,
               null,
                null,
                 menssagem);

                 throw new UsuarioJaCadastradoException(menssagem, fieldError);
        }
    }
}
