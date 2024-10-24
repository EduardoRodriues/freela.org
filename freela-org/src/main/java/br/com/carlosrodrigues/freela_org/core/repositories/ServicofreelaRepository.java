package br.com.carlosrodrigues.freela_org.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carlosrodrigues.freela_org.core.models.ServicoFreela;

public interface ServicofreelaRepository extends JpaRepository <ServicoFreela, Long>  {
    
}
