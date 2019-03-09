package com.emprestimoapi.resource.operacao;

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
import com.emprestimoapi.model.operacao.Entrada;
import com.emprestimoapi.repository.operacao.EntradaRepository;

@RestController
@RequestMapping("/entradas")
public class EntradaResource {

	private @Autowired EntradaRepository entradaRepository;
	private @Autowired ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Entrada> entradas(){
		return entradaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Entrada> criar(@Valid @RequestBody Entrada entrada, HttpServletResponse response){
		Entrada entradaSalva = entradaRepository.save(entrada);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, entradaSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(entradaSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Entrada> buscarPeloCodigo(@PathVariable Long id){
		Entrada entrada = entradaRepository.findOne(id);
		return entrada != null ? ResponseEntity.ok(entrada) : ResponseEntity.notFound().build();
	}
}
