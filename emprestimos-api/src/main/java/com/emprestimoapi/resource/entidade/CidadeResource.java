package com.emprestimoapi.resource.entidade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.entidade.Cidade;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.CidadeRepository;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.entidade.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeResource extends BaseResource<Cidade>{

	private @Autowired CidadeRepository cidadeRepository;
	private @Autowired CidadeService service;
	

	@Override
	public BaseRepository<Cidade, Long> repository() {
		return cidadeRepository;
	}

	@Override
	public BaseService<Cidade> service() {
		return service;
	}
	
	
}
