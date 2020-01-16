package com.emprestimoapi.resource.entidade;


import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimoapi.event.RecursoCriadoEvent;
import com.emprestimoapi.model.entidade.Status;
import com.emprestimoapi.model.entidade.Usuario;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.UsuarioRepository;
import com.emprestimoapi.security.util.GeradorSenha;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.entidade.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource extends BaseResource<Usuario>{

	private @Autowired UsuarioRepository usuarioRepository;
	private @Autowired UsuarioService service;
	

	@Override
	public BaseRepository<Usuario, Long> repository() {
		return usuarioRepository;
	}

	@Override
	public BaseService<Usuario> service() {
		return service;
	}
	
	@GetMapping("/status")
	public List<Status> statusUsados(){
		return Usuario.statusUsados();
	}
	
	@PostMapping
	public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario, HttpServletResponse response){
		usuario.setSenha(GeradorSenha.gerarSenha(usuario.getSenha()));
		Usuario entidadeSalva = service.salvar(usuario);
		getPublisher().publishEvent(new RecursoCriadoEvent(this, response, entidadeSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(entidadeSalva);
	}
	
	@GetMapping("/alteraSenha/{senha}")
	public void alteraSenha(@PathVariable("senha") String senha){
		service.alteraSenha(senha);
	}
}
