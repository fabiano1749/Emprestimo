package com.emprestimoapi.resource.entidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.entidade.Endereco;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.EnderecoRepository;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.entidade.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoResource extends BaseResource<Endereco>{

	private @Autowired EnderecoRepository enderecoRepository;
	private @Autowired EnderecoService service;
	
	@Override
	public BaseRepository<Endereco, Long> repository() {
		return enderecoRepository;
	}

	@Override
	public BaseService<Endereco> service() {
		return service;
	}
}
