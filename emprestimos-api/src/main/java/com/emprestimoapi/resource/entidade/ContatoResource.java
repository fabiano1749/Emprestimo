package com.emprestimoapi.resource.entidade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimoapi.model.entidade.Contato;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.ContatoRepository;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.entidade.ContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoResource extends BaseResource<Contato>{

	private @Autowired ContatoRepository contatoRepository;
	private @Autowired ContatoService service;
	

	@Override
	public BaseRepository<Contato, Long> repository() {
		return contatoRepository;
	}

	@Override
	public BaseService<Contato> service() {
		return service;
	}
	
	
	
}
