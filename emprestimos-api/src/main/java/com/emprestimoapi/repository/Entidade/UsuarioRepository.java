package com.emprestimoapi.repository.Entidade;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emprestimoapi.model.entidade.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
