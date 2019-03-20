package com.emprestimoapi.resource.operacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.operacao.TipoEntrada;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.TipoEntradaRepository;
import com.emprestimoapi.resource.entidade.BaseResource;

@RestController
@RequestMapping("/tiposEntradas")
public class TipoEntradaResource extends BaseResource<TipoEntrada>{

	private @Autowired TipoEntradaRepository tipoEntradaRepository;
//	private @Autowired ApplicationEventPublisher publisher;
//	
//	@GetMapping
//	public List<TipoEntrada> tiposEntradas(){
//		return tipoEntradaRepository.findAll();
//	}
//	
//	@PostMapping
//	public ResponseEntity<TipoEntrada> criar(@Valid @RequestBody TipoEntrada tipoEntrada, HttpServletResponse response){
//		TipoEntrada tipoEntradaSalva = tipoEntradaRepository.save(tipoEntrada);
//		publisher.publishEvent(new RecursoCriadoEvent(this, response, tipoEntradaSalva.getId()));
//		return ResponseEntity.status(HttpStatus.CREATED).body(tipoEntradaSalva);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<TipoEntrada> buscarPeloCodigo(@PathVariable Long id){
//		TipoEntrada tipoEntrada = tipoEntradaRepository.findOne(id);
//		return tipoEntrada != null ? ResponseEntity.ok(tipoEntrada) : ResponseEntity.notFound().build();
//	}

	@Override
	public BaseRepository<TipoEntrada, Long> repository() {
		return tipoEntradaRepository;
	}
}
