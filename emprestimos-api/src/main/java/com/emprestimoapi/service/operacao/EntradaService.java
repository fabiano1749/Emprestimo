package com.emprestimoapi.service.operacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.operacao.Entrada;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.EntradaRepository;
import com.emprestimoapi.service.entidade.BaseService;

@Service
public class EntradaService extends BaseService<Entrada>{

	private @Autowired EntradaRepository entradaRepository;

	@Override
	public BaseRepository<Entrada, Long> repository() {
		return entradaRepository;
	}
}
