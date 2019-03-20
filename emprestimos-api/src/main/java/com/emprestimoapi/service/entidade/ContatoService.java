package com.emprestimoapi.service.entidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.entidade.Contato;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.ContatoRepository;

@Service
public class ContatoService extends BaseService<Contato>{

	private @Autowired ContatoRepository contatoRepository;

	@Override
	public BaseRepository<Contato, Long> repository() {
		return contatoRepository;
	}
}
