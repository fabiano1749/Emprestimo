package com.emprestimoapi.service.entidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.entidade.Cidade;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.CidadeRepository;

@Service
public class CidadeService extends BaseService<Cidade>{

	private @Autowired CidadeRepository cidadeRepository;

	@Override
	public BaseRepository<Cidade, Long> repository() {
		return cidadeRepository;
	}
}
