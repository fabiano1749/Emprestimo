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
import com.emprestimoapi.model.operacao.Emprestimo;
import com.emprestimoapi.repository.operacao.EmprestimoRepository;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoResource {

	private @Autowired EmprestimoRepository emprestimoRepository;
	private @Autowired ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Emprestimo> emprestimos(){
		return emprestimoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Emprestimo> criar(@Valid @RequestBody Emprestimo emprestimo, HttpServletResponse response){
		Emprestimo emprestimoSalvo = emprestimoRepository.save(emprestimo);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, emprestimoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Emprestimo> buscarPeloCodigo(@PathVariable Long id){
		Emprestimo emprestimo = emprestimoRepository.findOne(id);
		return emprestimo != null ? ResponseEntity.ok(emprestimo) : ResponseEntity.notFound().build();
	}
}
