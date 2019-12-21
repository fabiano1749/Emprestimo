package com.emprestimoapi.service.entidade;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.entidade.Estado;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.EstadoRepository;

@Service
public class EstadoService extends BaseService<Estado>{

	private @Autowired EstadoRepository estadoRepository;

	public Estado atualizar(Long id, Estado entidade) {
		Estado entidadeSalva = repository().getOne(id);
		if(entidadeSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(entidade, entidadeSalva, "id");
		return repository().save(entidadeSalva);
	}
	
	
	@Override
	public BaseRepository<Estado, Long> repository() {
		return estadoRepository;
	}
}
