package com.emprestimoapi.repository.Entidade;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emprestimoapi.model.entidade.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long>{

}
