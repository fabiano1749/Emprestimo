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
import com.emprestimoapi.model.operacao.TipoEntrada;
import com.emprestimoapi.repository.operacao.TipoEntradaRepository;

@RestController
@RequestMapping("/tiposEntradas")
public class TipoEntradaResource {

	private @Autowired TipoEntradaRepository tipoEntradaRepository;
	private @Autowired ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<TipoEntrada> tiposEntradas(){
		return tipoEntradaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<TipoEntrada> criar(@Valid @RequestBody TipoEntrada tipoEntrada, HttpServletResponse response){
		TipoEntrada tipoEntradaSalva = tipoEntradaRepository.save(tipoEntrada);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, tipoEntradaSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoEntradaSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoEntrada> buscarPeloCodigo(@PathVariable Long id){
		TipoEntrada tipoEntrada = tipoEntradaRepository.findOne(id);
		return tipoEntrada != null ? ResponseEntity.ok(tipoEntrada) : ResponseEntity.notFound().build();
	}
}
