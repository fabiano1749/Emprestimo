package com.emprestimoapi.service.operacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.operacao.Transferencia;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.TransferenciaRepository;
import com.emprestimoapi.service.entidade.BaseService;

@Service
public class TransferenciaService extends BaseService<Transferencia>{

	private @Autowired TransferenciaRepository transferenciaRepository;

	@Override
	public BaseRepository<Transferencia, Long> repository() {
		return transferenciaRepository;
	}
}
