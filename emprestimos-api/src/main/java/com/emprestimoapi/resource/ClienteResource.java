package com.emprestimoapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimoapi.event.RecursoCriadoEvent;
import com.emprestimoapi.model.entidade.Cliente;
import com.emprestimoapi.repository.Entidade.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	private @Autowired ClienteRepository clienteRepository;
	
	private @Autowired ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Cliente> clientes(){
		return clienteRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente cliente, HttpServletResponse response){
		Cliente clienteSalvo = clienteRepository.save(cliente);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, clienteSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPeloCodigo(@PathVariable Long id){
		Cliente cliente = clienteRepository.findOne(id);
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}
}
