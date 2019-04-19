package com.emprestimoapi.repository.Entidade;


import java.util.Optional;

import com.emprestimoapi.model.entidade.Usuario;

public interface UsuarioRepository extends BaseRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);
	
}
