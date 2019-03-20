package com.emprestimoapi.resource.entidade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.entidade.Endereco;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.EnderecoRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoResource extends BaseResource<Endereco>{

	private @Autowired EnderecoRepository enderecoRepository;
	
//	private @Autowired ApplicationEventPublisher publisher;
	
//	@GetMapping
//	public List<Endereco> enderecos(){
//		return enderecoRepository.findAll();
//	}
//	
//	@PostMapping
//	public ResponseEntity<Endereco> criar(@Valid @RequestBody Endereco endereco, HttpServletResponse response){
//		Endereco enderecoSalvo = enderecoRepository.save(endereco);
//		publisher.publishEvent(new RecursoCriadoEvent(this, response, enderecoSalvo.getId()));
//		return ResponseEntity.status(HttpStatus.CREATED).body(enderecoSalvo);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<Endereco> buscarPeloCodigo(@PathVariable Long id){
//		Endereco endereco = enderecoRepository.findOne(id);
//		return endereco != null ? ResponseEntity.ok(endereco) : ResponseEntity.notFound().build();
//	}

	@Override
	public BaseRepository<Endereco, Long> repository() {
		return enderecoRepository;
	}
}
