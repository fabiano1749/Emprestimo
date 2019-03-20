package com.emprestimoapi.resource.entidade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimoapi.model.entidade.Contato;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.ContatoRepository;

@RestController
@RequestMapping("/contatos")
public class ContatoResource extends BaseResource<Contato>{

	private @Autowired ContatoRepository contatoRepository;
	
//	private @Autowired ApplicationEventPublisher publisher;
	
//	@GetMapping
//	public List<Contato> contatos(){
//		return contatoRepository.findAll();
//	}
//	
//	@PostMapping
//	public ResponseEntity<Contato> criar(@Valid @RequestBody Contato contato, HttpServletResponse response){
//		Contato contatoSalvo = contatoRepository.save(contato);
//		publisher.publishEvent(new RecursoCriadoEvent(this, response, contatoSalvo.getId()));
//		return ResponseEntity.status(HttpStatus.CREATED).body(contatoSalvo);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<Contato> buscarPeloCodigo(@PathVariable Long id){
//		Contato contato = contatoRepository.findOne(id);
//		return contato != null ? ResponseEntity.ok(contato) : ResponseEntity.notFound().build();
//	}

	@Override
	public BaseRepository<Contato, Long> repository() {
		return contatoRepository;
	}
	
	
	
}
