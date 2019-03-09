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
import com.emprestimoapi.model.entidade.Permissao;
import com.emprestimoapi.repository.Entidade.PermissaoRepository;

@RestController
@RequestMapping("/permissoes")
public class PermissaoResource {

	private @Autowired PermissaoRepository permissaoRepository;
	
	private @Autowired ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Permissao> permissaos(){
		return permissaoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Permissao> criar(@Valid @RequestBody Permissao permissao, HttpServletResponse response){
		Permissao permissaoSalva = permissaoRepository.save(permissao);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, permissaoSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(permissaoSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Permissao> buscarPeloCodigo(@PathVariable Long id){
		Permissao permissao = permissaoRepository.findOne(id);
		return permissao != null ? ResponseEntity.ok(permissao) : ResponseEntity.notFound().build();
	}
}
