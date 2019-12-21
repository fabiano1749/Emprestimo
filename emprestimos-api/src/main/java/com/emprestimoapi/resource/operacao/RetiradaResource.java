package com.emprestimoapi.resource.operacao;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimoapi.event.RecursoCriadoEvent;
import com.emprestimoapi.model.operacao.Retirada;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.RetiradaRepository;
import com.emprestimoapi.resource.entidade.BaseResource;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.operacao.RetiradaService;

@RestController
@RequestMapping("/retiradas")
public class RetiradaResource extends BaseResource<Retirada>{

	private @Autowired RetiradaRepository retiradaRepository;
	private @Autowired RetiradaService service;
	
	@Override
	public BaseRepository<Retirada, Long> repository() {
		return retiradaRepository;
	}

	@Override
	public BaseService<Retirada> service() {
		return service;
	}
	
	@PostMapping
	public ResponseEntity<Retirada> criar(@Valid @RequestBody Retirada entidade, HttpServletResponse response){
		Retirada entidadeSalva = service.salvar(entidade);
		getPublisher().publishEvent(new RecursoCriadoEvent(this, response, entidadeSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(entidadeSalva);
	}
}
