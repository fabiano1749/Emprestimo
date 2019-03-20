package com.emprestimoapi.resource.entidade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.entidade.TipoUsuario;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.TipoUsuarioRepository;

@RestController
@RequestMapping("/tipoUsuarios")
public class TipoUsuarioResource extends BaseResource<TipoUsuario>{

	private @Autowired TipoUsuarioRepository tipoUsuarioRepository;
//	
//	private @Autowired ApplicationEventPublisher publisher;
//	
//	@GetMapping
//	public List<TipoUsuario> tipoUsuarios(){
//		return tipoUsuarioRepository.findAll();
//	}
//	
//	@PostMapping
//	public ResponseEntity<TipoUsuario> criar(@Valid @RequestBody TipoUsuario tipoUsuario, HttpServletResponse response){
//		TipoUsuario tipoUsuarioSalva = tipoUsuarioRepository.save(tipoUsuario);
//		publisher.publishEvent(new RecursoCriadoEvent(this, response, tipoUsuarioSalva.getId()));
//		return ResponseEntity.status(HttpStatus.CREATED).body(tipoUsuarioSalva);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<TipoUsuario> buscarPeloCodigo(@PathVariable Long id){
//		TipoUsuario tipoUsuario = tipoUsuarioRepository.findOne(id);
//		return tipoUsuario != null ? ResponseEntity.ok(tipoUsuario) : ResponseEntity.notFound().build();
//	}

	@Override
	public BaseRepository<TipoUsuario, Long> repository() {
		return tipoUsuarioRepository;
	}
}
