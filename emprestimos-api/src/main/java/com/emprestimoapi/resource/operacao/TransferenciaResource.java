package com.emprestimoapi.resource.operacao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.operacao.Transferencia;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.TransferenciaRepository;
import com.emprestimoapi.resource.entidade.BaseResource;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.operacao.TransferenciaService;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaResource extends BaseResource<Transferencia>{

	private @Autowired TransferenciaRepository transferenciaRepository;
	private @Autowired TransferenciaService service;

	@Override
	public BaseRepository<Transferencia, Long> repository() {
		return transferenciaRepository;
	}

	@Override
	public BaseService<Transferencia> service() {
		return service;
	}
}
