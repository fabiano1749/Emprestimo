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
import com.emprestimoapi.model.operacao.Conta;
import com.emprestimoapi.repository.operacao.ContaRepository;

@RestController
@RequestMapping("/contas")
public class ContaResource {

	private @Autowired ContaRepository contaRepository;
	private @Autowired ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Conta> contas(){
		return contaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Conta> criar(@Valid @RequestBody Conta conta, HttpServletResponse response){
		Conta contaSalva = contaRepository.save(conta);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, contaSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(contaSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Conta> buscarPeloCodigo(@PathVariable Long id){
		Conta conta = contaRepository.findOne(id);
		return conta != null ? ResponseEntity.ok(conta) : ResponseEntity.notFound().build();
	}
}
