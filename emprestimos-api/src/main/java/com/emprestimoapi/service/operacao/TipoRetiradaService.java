package com.emprestimoapi.service.operacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.operacao.TipoRetirada;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.TipoRetiradaRepository;
import com.emprestimoapi.service.entidade.BaseService;

@Service
public class TipoRetiradaService extends BaseService<TipoRetirada>{

	private @Autowired TipoRetiradaRepository tipoRetiradaRepository;

	@Override
	public BaseRepository<TipoRetirada, Long> repository() {
		return tipoRetiradaRepository;
	}
}
