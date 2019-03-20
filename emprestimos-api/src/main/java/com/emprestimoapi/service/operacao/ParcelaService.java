package com.emprestimoapi.service.operacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.operacao.Parcela;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.ParcelaRepository;
import com.emprestimoapi.service.entidade.BaseService;

@Service
public class ParcelaService extends BaseService<Parcela>{

	private @Autowired ParcelaRepository parcelaRepository;

	@Override
	public BaseRepository<Parcela, Long> repository() {
		return parcelaRepository;
	}
}
