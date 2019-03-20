package com.emprestimoapi.resource.operacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.operacao.Retirada;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.RetiradaRepository;
import com.emprestimoapi.resource.entidade.BaseResource;

@RestController
@RequestMapping("/retiradas")
public class RetiradaResource extends BaseResource<Retirada>{

	private @Autowired RetiradaRepository retiradaRepository;
//	private @Autowired ApplicationEventPublisher publisher;
//	
//	@GetMapping
//	public List<Retirada> retiradas(){
//		return retiradaRepository.findAll();
//	}
//	
//	@PostMapping
//	public ResponseEntity<Retirada> criar(@Valid @RequestBody Retirada retirada, HttpServletResponse response){
//		Retirada retiradaSalva = retiradaRepository.save(retirada);
//		publisher.publishEvent(new RecursoCriadoEvent(this, response, retiradaSalva.getId()));
//		return ResponseEntity.status(HttpStatus.CREATED).body(retiradaSalva);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<Retirada> buscarPeloCodigo(@PathVariable Long id){
//		Retirada retirada = retiradaRepository.findOne(id);
//		return retirada != null ? ResponseEntity.ok(retirada) : ResponseEntity.notFound().build();
//	}

	@Override
	public BaseRepository<Retirada, Long> repository() {
		return retiradaRepository;
	}
}
