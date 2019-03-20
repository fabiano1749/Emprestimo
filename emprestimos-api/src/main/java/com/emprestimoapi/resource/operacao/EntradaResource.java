package com.emprestimoapi.resource.operacao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.operacao.Entrada;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.EntradaRepository;
import com.emprestimoapi.resource.entidade.BaseResource;

@RestController
@RequestMapping("/entradas")
public class EntradaResource extends BaseResource<Entrada>{

	private @Autowired EntradaRepository entradaRepository;
//	private @Autowired ApplicationEventPublisher publisher;
//	
//	@GetMapping
//	public List<Entrada> entradas(){
//		return entradaRepository.findAll();
//	}
//	
//	@PostMapping
//	public ResponseEntity<Entrada> criar(@Valid @RequestBody Entrada entrada, HttpServletResponse response){
//		Entrada entradaSalva = entradaRepository.save(entrada);
//		publisher.publishEvent(new RecursoCriadoEvent(this, response, entradaSalva.getId()));
//		return ResponseEntity.status(HttpStatus.CREATED).body(entradaSalva);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<Entrada> buscarPeloCodigo(@PathVariable Long id){
//		Entrada entrada = entradaRepository.findOne(id);
//		return entrada != null ? ResponseEntity.ok(entrada) : ResponseEntity.notFound().build();
//	}

	@Override
	public BaseRepository<Entrada, Long> repository() {
		return entradaRepository;
	}
}
