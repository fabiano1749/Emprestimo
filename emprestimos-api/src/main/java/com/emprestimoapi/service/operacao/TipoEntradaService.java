package com.emprestimoapi.service.operacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.operacao.TipoEntrada;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.TipoEntradaRepository;
import com.emprestimoapi.service.entidade.BaseService;

@Service
public class TipoEntradaService extends BaseService<TipoEntrada>{

	private @Autowired TipoEntradaRepository tipoEntradaRepository;

	@Override
	public BaseRepository<TipoEntrada, Long> repository() {
		return tipoEntradaRepository;
	}
}
