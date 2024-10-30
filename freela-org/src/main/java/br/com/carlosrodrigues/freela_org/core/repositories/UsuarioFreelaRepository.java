package br.com.carlosrodrigues.freela_org.core.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.carlosrodrigues.freela_org.core.models.UsuarioFreela;

public interface UsuarioFreelaRepository extends JpaRepository <UsuarioFreela, Long> {
    
    Optional<UsuarioFreela> findByEmail(String email);

    @Query("SELECT count(*) > 0 FROM Usuario u WHERE u.email = :email and (:id is null or u.id != :id) ")
    Boolean isEmailJaCadastrado(String email, Long id);
}
