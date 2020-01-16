package com.emprestimoapi.resource.entidade;


import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimoapi.event.RecursoCriadoEvent;
import com.emprestimoapi.model.entidade.EntidadeBase;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.service.entidade.BaseService;

@RestController
public abstract class BaseResource <T extends EntidadeBase>{

	private @Autowired ApplicationEventPublisher publisher;

	public abstract BaseRepository<T, Long> repository();
	
	public abstract BaseService<T> service();
	
	@GetMapping
	public List<T> entidades(){
		return  repository().findAll();
	}
	
	@PostMapping
	public ResponseEntity<T> criar(@Valid @RequestBody T entidade, HttpServletResponse response){
		T entidadeSalva = repository().save(entidade);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, entidadeSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(entidadeSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<T> buscarPeloCodigo(@PathVariable Long id){
		T entidade = repository().findById(id).get();
		return entidade != null ? ResponseEntity.ok(entidade) : ResponseEntity.notFound().build();
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<T> atualizar(@PathVariable Long id, @Valid @RequestBody T entidade){
		return ResponseEntity.ok(service().atualizar(id, entidade));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id){
		repository().deleteById(id);
	}

	public ApplicationEventPublisher getPublisher() {
		return publisher;
	}
	
}
