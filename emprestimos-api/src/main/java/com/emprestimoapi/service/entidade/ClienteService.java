package com.emprestimoapi.service.entidade;

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
		
		cliente.getEnderecos().forEach(e -> e.setCliente(cliente));
		cliente.getContatos().forEach(c -> c.setCliente(cliente));
		return clienteRepository.save(cliente);	
	}
	
	public Cliente atualizar(Long id, Cliente entidade) {
		Cliente clienteSalvo = repository().findOne(id);
		if(clienteSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		clienteSalvo.getEnderecos().clear();
		clienteSalvo.getEnderecos().addAll(entidade.getEnderecos());
		clienteSalvo.getEnderecos().forEach(e -> e.setCliente(clienteSalvo));
		
		clienteSalvo.getContatos().clear();
		clienteSalvo.getContatos().addAll(entidade.getContatos());
		clienteSalvo.getContatos().forEach(c -> c.setCliente(clienteSalvo));
		
		BeanUtils.copyProperties(entidade, clienteSalvo, "id", "enderecos", "contatos");
		return repository().save(clienteSalvo);
	}
	
	
	@Override
	public BaseRepository<Cliente, Long> repository() {
		return clienteRepository;
	}
}
