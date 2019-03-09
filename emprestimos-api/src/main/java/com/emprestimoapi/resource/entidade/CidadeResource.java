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
import com.emprestimoapi.model.entidade.Cidade;
import com.emprestimoapi.repository.Entidade.CidadeRepository;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

	private @Autowired CidadeRepository cidadeRepository;
	
	private @Autowired ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Cidade> cidades(){
		return cidadeRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Cidade> criar(@Valid @RequestBody Cidade cidade, HttpServletResponse response){
		Cidade cidadeSalva = cidadeRepository.save(cidade);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, cidadeSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(cidadeSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> buscarPeloCodigo(@PathVariable Long id){
		Cidade cidade = cidadeRepository.findOne(id);
		return cidade != null ? ResponseEntity.ok(cidade) : ResponseEntity.notFound().build();
	}
}
