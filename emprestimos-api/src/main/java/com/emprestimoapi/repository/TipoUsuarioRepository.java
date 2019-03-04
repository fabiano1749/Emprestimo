package com.emprestimoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emprestimoapi.model.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long>{

}
