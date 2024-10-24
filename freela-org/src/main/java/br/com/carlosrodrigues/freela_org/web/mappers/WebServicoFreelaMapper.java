package br.com.carlosrodrigues.freela_org.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.carlosrodrigues.freela_org.core.models.ServicoFreela;
import br.com.carlosrodrigues.freela_org.web.dtos.ServicoFreelaForm;

@Mapper(componentModel = "spring")
public interface WebServicoFreelaMapper {
    
    @Mapping(target = "id", ignore = true)
    ServicoFreela toModel(ServicoFreelaForm form);

    ServicoFreelaForm toForm(ServicoFreela model);
}
