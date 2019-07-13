package com.emprestimoapi.resource.operacao;


import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimoapi.event.RecursoCriadoEvent;
import com.emprestimoapi.model.entidade.Status;
import com.emprestimoapi.model.operacao.Emprestimo;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.EmprestimoRepository;
import com.emprestimoapi.resource.entidade.BaseResource;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.operacao.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoResource extends BaseResource<Emprestimo>{

	private @Autowired EmprestimoRepository emprestimoRepository;
	private @Autowired EmprestimoService service;

	@PostMapping
	public ResponseEntity<Emprestimo> criar(@Valid @RequestBody Emprestimo entidade, HttpServletResponse response){
		Emprestimo entidadeSalva = service.salvar(entidade);
		getPublisher().publishEvent(new RecursoCriadoEvent(this, response, entidadeSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(entidadeSalva);
	}
	
	
	@Override
	public BaseRepository<Emprestimo, Long> repository() {
		return emprestimoRepository;
	}

	@Override
	public BaseService<Emprestimo> service() {
		return service;
	}
	
	@GetMapping("/status")
	public List<Status> statusUsados(){
		return Emprestimo.statusUsados();
	}
	
}
