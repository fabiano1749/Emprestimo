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
import com.emprestimoapi.model.operacao.TipoRetirada;
import com.emprestimoapi.repository.operacao.TipoRetiradaRepository;

@RestController
@RequestMapping("/tiposRetiradas")
public class TipoRetiradaResource {

	private @Autowired TipoRetiradaRepository tipoRetiradaRepository;
	private @Autowired ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<TipoRetirada> tiposRetiradas(){
		return tipoRetiradaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<TipoRetirada> criar(@Valid @RequestBody TipoRetirada tipoRetirada, HttpServletResponse response){
		TipoRetirada tipoRetiradaSalva = tipoRetiradaRepository.save(tipoRetirada);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, tipoRetiradaSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoRetiradaSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoRetirada> buscarPeloCodigo(@PathVariable Long id){
		TipoRetirada tipoRetirada = tipoRetiradaRepository.findOne(id);
		return tipoRetirada != null ? ResponseEntity.ok(tipoRetirada) : ResponseEntity.notFound().build();
	}
}
