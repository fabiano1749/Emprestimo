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
import com.emprestimoapi.model.entidade.Contato;
import com.emprestimoapi.repository.Entidade.ContatoRepository;

@RestController
@RequestMapping("/contatos")
public class ContatoResource {

	private @Autowired ContatoRepository contatoRepository;
	
	private @Autowired ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Contato> contatos(){
		return contatoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Contato> criar(@Valid @RequestBody Contato contato, HttpServletResponse response){
		Contato contatoSalvo = contatoRepository.save(contato);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, contatoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(contatoSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contato> buscarPeloCodigo(@PathVariable Long id){
		Contato contato = contatoRepository.findOne(id);
		return contato != null ? ResponseEntity.ok(contato) : ResponseEntity.notFound().build();
	}
}
