package com.emprestimoapi.resource.entidade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.entidade.Cidade;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.CidadeRepository;

@RestController
@RequestMapping("/cidades")
public class CidadeResource extends BaseResource<Cidade>{

	private @Autowired CidadeRepository cidadeRepository;
	
//	private @Autowired ApplicationEventPublisher publisher;
	
//	@GetMapping
//	public List<Cidade> cidades(){
//		return cidadeRepository.findAll();
//	}
//	
//	@PostMapping
//	public ResponseEntity<Cidade> criar(@Valid @RequestBody Cidade cidade, HttpServletResponse response){
//		Cidade cidadeSalva = cidadeRepository.save(cidade);
//		publisher.publishEvent(new RecursoCriadoEvent(this, response, cidadeSalva.getId()));
//		return ResponseEntity.status(HttpStatus.CREATED).body(cidadeSalva);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<Cidade> buscarPeloCodigo(@PathVariable Long id){
//		Cidade cidade = cidadeRepository.findOne(id);
//		return cidade != null ? ResponseEntity.ok(cidade) : ResponseEntity.notFound().build();
//	}

	@Override
	public BaseRepository<Cidade, Long> repository() {
		return cidadeRepository;
	}
}
