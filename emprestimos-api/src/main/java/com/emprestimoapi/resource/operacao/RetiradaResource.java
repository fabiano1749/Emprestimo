package com.emprestimoapi.resource.operacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.operacao.Retirada;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.RetiradaRepository;
import com.emprestimoapi.resource.entidade.BaseResource;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.operacao.RetiradaService;

@RestController
@RequestMapping("/retiradas")
public class RetiradaResource extends BaseResource<Retirada>{

	private @Autowired RetiradaRepository retiradaRepository;
	private @Autowired RetiradaService service;
	
	@Override
	public BaseRepository<Retirada, Long> repository() {
		return retiradaRepository;
	}

	@Override
	public BaseService<Retirada> service() {
		return service;
	}
}
