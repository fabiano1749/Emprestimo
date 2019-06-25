package com.emprestimoapi.resource.operacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.operacao.TipoEntrada;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.TipoEntradaRepository;
import com.emprestimoapi.resource.entidade.BaseResource;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.operacao.TipoEntradaService;

@RestController
@RequestMapping("/tiposEntradas")
public class TipoEntradaResource extends BaseResource<TipoEntrada>{

	private @Autowired TipoEntradaRepository tipoEntradaRepository;
	private @Autowired TipoEntradaService service;

	@Override
	public BaseRepository<TipoEntrada, Long> repository() {
		return tipoEntradaRepository;
	}

	@Override
	public BaseService<TipoEntrada> service() {
		return service;
	}
}
