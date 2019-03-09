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
import com.emprestimoapi.model.entidade.Estado;
import com.emprestimoapi.repository.Entidade.EstadoRepository;

@RestController
@RequestMapping("/estados")
public class EstadoResource{

	private @Autowired EstadoRepository estadoRepository;
	private @Autowired ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Estado> estados(){
		return  estadoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Estado> criar(@Valid @RequestBody Estado estado, HttpServletResponse response){
		Estado estadoSalvo = estadoRepository.save(estado);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, estadoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(estadoSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estado> buscarPeloCodigo(@PathVariable Long id){
		Estado estado = estadoRepository.findOne(id);
		return estado != null ? ResponseEntity.ok(estado) : ResponseEntity.notFound().build();
	}
}
