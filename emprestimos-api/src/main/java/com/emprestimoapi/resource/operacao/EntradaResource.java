package com.emprestimoapi.resource.operacao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.operacao.Entrada;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.EntradaRepository;
import com.emprestimoapi.resource.entidade.BaseResource;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.operacao.EntradaService;

@RestController
@RequestMapping("/entradas")
public class EntradaResource extends BaseResource<Entrada>{

	private @Autowired EntradaRepository entradaRepository;
	private @Autowired EntradaService service;

	@Override
	public BaseRepository<Entrada, Long> repository() {
		return entradaRepository;
	}

	@Override
	public BaseService<Entrada> service() {
		return service;
	}
}
