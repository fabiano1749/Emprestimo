package com.emprestimoapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.entidade.Estado;
import com.emprestimoapi.repository.Entidade.EstadoRepository;

@Service
public class EstadoService {

	private @Autowired EstadoRepository estadoRepository;
	
	public Estado atualizar(Long id, Estado estado) {
		Estado estadoSalvo = estadoRepository.findOne(id);
		if(estadoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(estado, estadoSalvo, "id");
		return estadoRepository.save(estadoSalvo);
	}
	
}
