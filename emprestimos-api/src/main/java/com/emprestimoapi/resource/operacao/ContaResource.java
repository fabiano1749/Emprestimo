package com.emprestimoapi.resource.operacao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimoapi.model.operacao.Conta;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.ContaRepository;
import com.emprestimoapi.resource.entidade.BaseResource;

@RestController
@RequestMapping("/contas")
public class ContaResource extends BaseResource<Conta>{

	private @Autowired ContaRepository contaRepository;
//	private @Autowired ApplicationEventPublisher publisher;
//	
//	@GetMapping
//	public List<Conta> contas(){
//		return contaRepository.findAll();
//	}
//	
//	@PostMapping
//	public ResponseEntity<Conta> criar(@Valid @RequestBody Conta conta, HttpServletResponse response){
//		Conta contaSalva = contaRepository.save(conta);
//		publisher.publishEvent(new RecursoCriadoEvent(this, response, contaSalva.getId()));
//		return ResponseEntity.status(HttpStatus.CREATED).body(contaSalva);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<Conta> buscarPeloCodigo(@PathVariable Long id){
//		Conta conta = contaRepository.findOne(id);
//		return conta != null ? ResponseEntity.ok(conta) : ResponseEntity.notFound().build();
//	}

	@Override
	public BaseRepository<Conta, Long> repository() {
		return contaRepository;
	}
}
