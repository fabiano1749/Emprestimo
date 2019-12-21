package com.emprestimoapi.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.entidade.Usuario;
import com.emprestimoapi.repository.Entidade.UsuarioRepository;

@Service
public class UsuarioLogado {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario usuarioLogado() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Optional<Usuario> usuarioOptional = usuarioRepository.findByUsername(username);
		Usuario usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha inválidos"));
		return usuario;
	}
}
