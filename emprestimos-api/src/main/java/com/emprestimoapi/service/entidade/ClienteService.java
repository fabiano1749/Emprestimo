package com.emprestimoapi.service.entidade;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.entidade.Cliente;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.ClienteRepository;

@Service
public class ClienteService extends BaseService<Cliente>{

	private @Autowired ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) {
		if(cliente.getId() != null) {
			return atualizar(cliente.getId(), cliente);
		}
		
		cliente.getEnderecos().forEach(e -> e.setEntidade(cliente));
		cliente.getContatos().forEach(c -> c.setEntidade(cliente));
		return clienteRepository.save(cliente);	
	}
	
	public Cliente atualizar(Long id, Cliente entidade) {
		Optional<Cliente> clienteSalvo = repository().findById(id);
		if(!clienteSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		clienteSalvo.get().getEnderecos().clear();
		clienteSalvo.get().getEnderecos().addAll(entidade.getEnderecos());
		clienteSalvo.get().getEnderecos().forEach(e -> e.setEntidade(clienteSalvo.get()));
		
		clienteSalvo.get().getContatos().clear();
		clienteSalvo.get().getContatos().addAll(entidade.getContatos());
		clienteSalvo.get().getContatos().forEach(c -> c.setEntidade(clienteSalvo.get()));
		
		BeanUtils.copyProperties(entidade, clienteSalvo, "id", "enderecos", "contatos");
		return repository().save(clienteSalvo.get());
	}
	
	
	@Override
	public BaseRepository<Cliente, Long> repository() {
		return clienteRepository;
	}
}
