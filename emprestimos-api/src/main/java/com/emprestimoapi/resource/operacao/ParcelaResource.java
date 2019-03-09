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
import com.emprestimoapi.model.operacao.Parcela;
import com.emprestimoapi.repository.operacao.ParcelaRepository;

@RestController
@RequestMapping("/parcelas")
public class ParcelaResource {

	private @Autowired ParcelaRepository parcelaRepository;
	private @Autowired ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Parcela> parcelas(){
		return parcelaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Parcela> criar(@Valid @RequestBody Parcela parcela, HttpServletResponse response){
		Parcela parcelaSalva = parcelaRepository.save(parcela);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, parcelaSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(parcelaSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Parcela> buscarPeloCodigo(@PathVariable Long id){
		Parcela parcela = parcelaRepository.findOne(id);
		return parcela != null ? ResponseEntity.ok(parcela) : ResponseEntity.notFound().build();
	}
}
