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
import com.emprestimoapi.model.TipoUsuario;
import com.emprestimoapi.repository.TipoUsuarioRepository;

@RestController
@RequestMapping("/tipoUsuarios")
public class TipoUsuarioResource {

	private @Autowired TipoUsuarioRepository tipoUsuarioRepository;
	
	private @Autowired ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<TipoUsuario> tipoUsuarios(){
		return tipoUsuarioRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<TipoUsuario> criar(@Valid @RequestBody TipoUsuario tipoUsuario, HttpServletResponse response){
		TipoUsuario tipoUsuarioSalva = tipoUsuarioRepository.save(tipoUsuario);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, tipoUsuarioSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoUsuarioSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoUsuario> buscarPeloCodigo(@PathVariable Long id){
		TipoUsuario tipoUsuario = tipoUsuarioRepository.findOne(id);
		return tipoUsuario != null ? ResponseEntity.ok(tipoUsuario) : ResponseEntity.notFound().build();
	}
}
