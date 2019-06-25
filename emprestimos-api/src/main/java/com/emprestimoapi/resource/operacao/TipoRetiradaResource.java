package com.emprestimoapi.resource.operacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimoapi.model.operacao.TipoRetirada;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.TipoRetiradaRepository;
import com.emprestimoapi.resource.entidade.BaseResource;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.operacao.TipoRetiradaService;

@RestController
@RequestMapping("/tiposRetiradas")
public class TipoRetiradaResource extends BaseResource<TipoRetirada>{

	private @Autowired TipoRetiradaRepository tipoRetiradaRepository;
	private @Autowired TipoRetiradaService service;

	@Override
	public BaseRepository<TipoRetirada, Long> repository() {
		return tipoRetiradaRepository;
	}

	@Override
	public BaseService<TipoRetirada> service() {
		return service;
	}
}
