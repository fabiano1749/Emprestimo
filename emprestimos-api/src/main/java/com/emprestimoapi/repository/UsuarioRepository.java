package com.emprestimoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emprestimoapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
