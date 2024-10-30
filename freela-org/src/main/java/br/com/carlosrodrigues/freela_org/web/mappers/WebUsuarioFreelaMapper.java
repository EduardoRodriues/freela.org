package br.com.carlosrodrigues.freela_org.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.carlosrodrigues.freela_org.core.models.UsuarioFreela;
import br.com.carlosrodrigues.freela_org.web.dtos.UsuarioFreelaCadastroForm;
import br.com.carlosrodrigues.freela_org.web.dtos.UsuarioFreelaEdicaoForm;

@Mapper(componentModel = "spring")
public interface WebUsuarioFreelaMapper {
    
    @Mapping(target = "id", ignore =  true)
    @Mapping(target = "tipoUsuario", ignore =  true)
    UsuarioFreela toModel(UsuarioFreelaCadastroForm form);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "senha", ignore = true)
    @Mapping(target = "tipoUsuario", ignore = true)
    UsuarioFreela toModel(UsuarioFreelaEdicaoForm form);

    UsuarioFreelaEdicaoForm toForm(UsuarioFreela model);
}
