package com.emprestimoapi.resource.operacao;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimoapi.model.operacao.Parcela;
import com.emprestimoapi.model.operacao.resumoConsultas.ResumoParcela;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.filter.ParcelaFilter;
import com.emprestimoapi.repository.operacao.ParcelaRepository;
import com.emprestimoapi.resource.entidade.BaseResource;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.operacao.ParcelaService;

@RestController
@RequestMapping("/parcelas")
public class ParcelaResource extends BaseResource<Parcela>{

	private @Autowired ParcelaRepository parcelaRepository;
	private @Autowired ParcelaService service;

	@Override
	public BaseRepository<Parcela, Long> repository() {
		return parcelaRepository;
	}

	@Override
	public BaseService<Parcela> service() {
		return service;
	}
	
	@GetMapping("pesquisa")
	public List<ResumoParcela> pesquisar(ParcelaFilter filtro) {
		return parcelaRepository.filtrarResumo(filtro);
	}
}
