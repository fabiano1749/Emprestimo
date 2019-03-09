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
import com.emprestimoapi.model.entidade.Usuario;
import com.emprestimoapi.repository.Entidade.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

	private @Autowired UsuarioRepository usuarioRepository;
	
	private @Autowired ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Usuario> usuarios(){
		return usuarioRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario, HttpServletResponse response){
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPeloCodigo(@PathVariable Long id){
		Usuario usuario = usuarioRepository.findOne(id);
		return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
	}
}
