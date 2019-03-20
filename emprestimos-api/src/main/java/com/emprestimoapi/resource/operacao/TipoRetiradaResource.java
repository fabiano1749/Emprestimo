package com.emprestimoapi.resource.operacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimoapi.model.operacao.TipoRetirada;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.TipoRetiradaRepository;
import com.emprestimoapi.resource.entidade.BaseResource;

@RestController
@RequestMapping("/tiposRetiradas")
public class TipoRetiradaResource extends BaseResource<TipoRetirada>{

	private @Autowired TipoRetiradaRepository tipoRetiradaRepository;
//	private @Autowired ApplicationEventPublisher publisher;
//	
//	@GetMapping
//	public List<TipoRetirada> tiposRetiradas(){
//		return tipoRetiradaRepository.findAll();
//	}
//	
//	@PostMapping
//	public ResponseEntity<TipoRetirada> criar(@Valid @RequestBody TipoRetirada tipoRetirada, HttpServletResponse response){
//		TipoRetirada tipoRetiradaSalva = tipoRetiradaRepository.save(tipoRetirada);
//		publisher.publishEvent(new RecursoCriadoEvent(this, response, tipoRetiradaSalva.getId()));
//		return ResponseEntity.status(HttpStatus.CREATED).body(tipoRetiradaSalva);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<TipoRetirada> buscarPeloCodigo(@PathVariable Long id){
//		TipoRetirada tipoRetirada = tipoRetiradaRepository.findOne(id);
//		return tipoRetirada != null ? ResponseEntity.ok(tipoRetirada) : ResponseEntity.notFound().build();
//	}

	@Override
	public BaseRepository<TipoRetirada, Long> repository() {
		return tipoRetiradaRepository;
	}
}
