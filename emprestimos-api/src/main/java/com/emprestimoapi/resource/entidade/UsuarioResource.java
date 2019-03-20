package com.emprestimoapi.resource.entidade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.entidade.Usuario;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource extends BaseResource<Usuario>{

	private @Autowired UsuarioRepository usuarioRepository;
	
//	private @Autowired ApplicationEventPublisher publisher;
//	
//	@GetMapping
//	public List<Usuario> usuarios(){
//		return usuarioRepository.findAll();
//	}
//	
//	@PostMapping
//	public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario, HttpServletResponse response){
//		Usuario usuarioSalvo = usuarioRepository.save(usuario);
//		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getId()));
//		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<Usuario> buscarPeloCodigo(@PathVariable Long id){
//		Usuario usuario = usuarioRepository.findOne(id);
//		return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
//	}

	@Override
	public BaseRepository<Usuario, Long> repository() {
		return usuarioRepository;
	}
}
