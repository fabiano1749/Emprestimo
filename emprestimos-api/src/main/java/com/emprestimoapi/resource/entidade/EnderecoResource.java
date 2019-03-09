package com.emprestimoapi.resource.entidade;

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
import com.emprestimoapi.model.entidade.Endereco;
import com.emprestimoapi.repository.Entidade.EnderecoRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoResource {

	private @Autowired EnderecoRepository enderecoRepository;
	
	private @Autowired ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Endereco> enderecos(){
		return enderecoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Endereco> criar(@Valid @RequestBody Endereco endereco, HttpServletResponse response){
		Endereco enderecoSalvo = enderecoRepository.save(endereco);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, enderecoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(enderecoSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> buscarPeloCodigo(@PathVariable Long id){
		Endereco endereco = enderecoRepository.findOne(id);
		return endereco != null ? ResponseEntity.ok(endereco) : ResponseEntity.notFound().build();
	}
}
