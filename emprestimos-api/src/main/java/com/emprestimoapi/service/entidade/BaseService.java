package com.emprestimoapi.service.entidade;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.entidade.EntidadeBase;
import com.emprestimoapi.model.entidade.Usuario;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.security.UsuarioLogado;

@Service
public abstract class BaseService<T extends EntidadeBase> {

	public abstract BaseRepository<T, Long> repository();
	
	@Autowired
	private UsuarioLogado usuarioLogado;
	
	
	public T atualizar(Long id, T entidade) {
		Optional<T> entidadeSalva = repository().findById(id);
		if(!entidadeSalva.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(entidade, entidadeSalva, "id");
		return repository().save(entidadeSalva.get());
	}

	private UsuarioLogado getUsuario() {
		return usuarioLogado;
	}
	
	public Usuario getUsuarioLogado() {
		return getUsuario().usuarioLogado();
	}
}
