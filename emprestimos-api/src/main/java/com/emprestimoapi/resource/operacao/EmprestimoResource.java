package com.emprestimoapi.resource.operacao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.operacao.Emprestimo;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.EmprestimoRepository;
import com.emprestimoapi.resource.entidade.BaseResource;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoResource extends BaseResource<Emprestimo>{

	private @Autowired EmprestimoRepository emprestimoRepository;
//	private @Autowired ApplicationEventPublisher publisher;
//	
//	@GetMapping
//	public List<Emprestimo> emprestimos(){
//		return emprestimoRepository.findAll();
//	}
//	
//	@PostMapping
//	public ResponseEntity<Emprestimo> criar(@Valid @RequestBody Emprestimo emprestimo, HttpServletResponse response){
//		Emprestimo emprestimoSalvo = emprestimoRepository.save(emprestimo);
//		publisher.publishEvent(new RecursoCriadoEvent(this, response, emprestimoSalvo.getId()));
//		return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoSalvo);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<Emprestimo> buscarPeloCodigo(@PathVariable Long id){
//		Emprestimo emprestimo = emprestimoRepository.findOne(id);
//		return emprestimo != null ? ResponseEntity.ok(emprestimo) : ResponseEntity.notFound().build();
//	}

	@Override
	public BaseRepository<Emprestimo, Long> repository() {
		return emprestimoRepository;
	}
}
