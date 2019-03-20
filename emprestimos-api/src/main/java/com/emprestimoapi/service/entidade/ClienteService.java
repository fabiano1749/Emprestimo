package com.emprestimoapi.service.entidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.entidade.Cliente;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.ClienteRepository;

@Service
public class ClienteService extends BaseService<Cliente>{

	private @Autowired ClienteRepository clienteRepository;

	@Override
	public BaseRepository<Cliente, Long> repository() {
		return clienteRepository;
	}
}
