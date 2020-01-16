package com.emprestimoapi.service.entidade;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.entidade.Usuario;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.TipoUsuarioRepository;
import com.emprestimoapi.repository.Entidade.UsuarioRepository;

@Service
public class UsuarioService extends BaseService<Usuario>{

	private @Autowired UsuarioRepository usuarioRepository;
	private @Autowired TipoUsuarioRepository tipoUsuarioRepository;

	@Override
	public BaseRepository<Usuario, Long> repository() {
		return usuarioRepository;
	}
	
	public Usuario salvar(Usuario usuario) {
		if (usuario.getId() != null) {
			return atualizar(usuario.getId(), usuario);
		}
		usuario.setClientes(new ArrayList<>());
		usuario.setContas(new ArrayList<>());
		usuario.setContatos(new ArrayList<>());
		usuario.setEnderecos(new ArrayList<>());
		return usuarioRepository.save(usuario);
	}

	public Usuario atualizar(Long id, Usuario usuario) {
		Optional<Usuario> usuarioSalvo = repository().findById(id);
		if (usuarioSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		usuarioSalvo.get().setTipo(tipoUsuarioRepository.findById(usuario.getTipo().getId()).get());
		BeanUtils.copyProperties(usuario, usuarioSalvo.get(), "id", "clientes", "contas", "contatos", "enderecos");
		return repository().save(usuarioSalvo.get());
	}
	
	public void alteraSenha(String senha) {
		Usuario usuario = getUsuarioLogado();
		usuario.alteraSenha(senha);
		usuarioRepository.save(usuario);
	}
	
}
