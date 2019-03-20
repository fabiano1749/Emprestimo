package com.emprestimoapi.service.operacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.operacao.Conta;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.ContaRepository;
import com.emprestimoapi.service.entidade.BaseService;

@Service
public class ContaService extends BaseService<Conta>{

	private @Autowired ContaRepository contaRepository;

	@Override
	public BaseRepository<Conta, Long> repository() {
		return contaRepository;
	}
}
