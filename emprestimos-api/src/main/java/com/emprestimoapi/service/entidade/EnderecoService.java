package com.emprestimoapi.service.entidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.entidade.Endereco;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.EnderecoRepository;

@Service
public class EnderecoService extends BaseService<Endereco>{

	private @Autowired EnderecoRepository enderecoRepository;

	@Override
	public BaseRepository<Endereco, Long> repository() {
		return enderecoRepository;
	}
}
