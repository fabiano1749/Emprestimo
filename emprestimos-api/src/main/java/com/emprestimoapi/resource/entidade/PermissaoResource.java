package com.emprestimoapi.resource.entidade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.entidade.Permissao;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.PermissaoRepository;

@RestController
@RequestMapping("/permissoes")
public class PermissaoResource extends BaseResource<Permissao>{

	private @Autowired PermissaoRepository permissaoRepository;
	
//	private @Autowired ApplicationEventPublisher publisher;
	
//	@GetMapping
//	public List<Permissao> permissaos(){
//		return permissaoRepository.findAll();
//	}
//	
//	@PostMapping
//	public ResponseEntity<Permissao> criar(@Valid @RequestBody Permissao permissao, HttpServletResponse response){
//		Permissao permissaoSalva = permissaoRepository.save(permissao);
//		publisher.publishEvent(new RecursoCriadoEvent(this, response, permissaoSalva.getId()));
//		return ResponseEntity.status(HttpStatus.CREATED).body(permissaoSalva);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<Permissao> buscarPeloCodigo(@PathVariable Long id){
//		Permissao permissao = permissaoRepository.findOne(id);
//		return permissao != null ? ResponseEntity.ok(permissao) : ResponseEntity.notFound().build();
//	}

	@Override
	public BaseRepository<Permissao, Long> repository() {
		return permissaoRepository;
	}
}
