package com.emprestimoapi.resource.operacao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimoapi.model.entidade.Status;
import com.emprestimoapi.model.operacao.Conta;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.ContaRepository;
import com.emprestimoapi.resource.entidade.BaseResource;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.operacao.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaResource extends BaseResource<Conta>{

	private @Autowired ContaRepository contaRepository;
	private @Autowired ContaService service;


	@Override
	public BaseRepository<Conta, Long> repository() {
		return contaRepository;
	}

	@Override
	public BaseService<Conta> service() {
		return service;
	}
	
	@GetMapping("/status")
	public List<Status> statusUsados(){
		return Conta.statusUsados();
	}
}
