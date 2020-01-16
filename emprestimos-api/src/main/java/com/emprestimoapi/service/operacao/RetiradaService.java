package com.emprestimoapi.service.operacao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.entidade.Status;
import com.emprestimoapi.model.operacao.Retirada;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.RetiradaRepository;
import com.emprestimoapi.service.entidade.BaseService;

@Service
public class RetiradaService extends BaseService<Retirada>{

	private @Autowired RetiradaRepository retiradaRepository;

	@Override
	public BaseRepository<Retirada, Long> repository() {
		return retiradaRepository;
	}
	
	public Retirada salvar(Retirada retirada) {
		retirada.setUsuario(getUsuarioLogado());
		retirada.setStatus(Status.FECHADO);
		retirada.geraLog(getUsuarioLogado(), "Registro de operação de retirada de recursos");
		return retiradaRepository.save(retirada);
	}
}
