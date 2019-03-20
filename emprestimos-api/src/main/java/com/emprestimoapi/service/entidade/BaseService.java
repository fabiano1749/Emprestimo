package com.emprestimoapi.service.entidade;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.entidade.EntidadeBase;
import com.emprestimoapi.repository.Entidade.BaseRepository;

@Service
public abstract class BaseService<T extends EntidadeBase> {

	public abstract BaseRepository<T, Long> repository();
	
	
	public T atualizar(Long id, T entidade) {
		T entidadeSalva = repository().findOne(id);
		if(entidadeSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(entidade, entidadeSalva, "id");
		return repository().save(entidadeSalva);
	}
	
}
