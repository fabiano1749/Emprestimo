package com.emprestimoapi.service.entidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.entidade.Usuario;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.UsuarioRepository;

@Service
public class UsuarioService extends BaseService<Usuario>{

	private @Autowired UsuarioRepository usuarioRepository;

	@Override
	public BaseRepository<Usuario, Long> repository() {
		return usuarioRepository;
	}
	
	public void alteraSenha(String senha) {
		Usuario usuario = getUsuarioLogado();
		usuario.alteraSenha(senha);
		usuarioRepository.save(usuario);
	}
	
}
