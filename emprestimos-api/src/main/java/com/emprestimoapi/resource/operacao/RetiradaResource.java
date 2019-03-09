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
import com.emprestimoapi.model.operacao.Retirada;
import com.emprestimoapi.repository.operacao.RetiradaRepository;

@RestController
@RequestMapping("/retiradas")
public class RetiradaResource {

	private @Autowired RetiradaRepository retiradaRepository;
	private @Autowired ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Retirada> retiradas(){
		return retiradaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Retirada> criar(@Valid @RequestBody Retirada retirada, HttpServletResponse response){
		Retirada retiradaSalva = retiradaRepository.save(retirada);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, retiradaSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(retiradaSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Retirada> buscarPeloCodigo(@PathVariable Long id){
		Retirada retirada = retiradaRepository.findOne(id);
		return retirada != null ? ResponseEntity.ok(retirada) : ResponseEntity.notFound().build();
	}
}
