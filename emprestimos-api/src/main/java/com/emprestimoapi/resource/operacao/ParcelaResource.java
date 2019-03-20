package com.emprestimoapi.resource.operacao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.operacao.Parcela;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.ParcelaRepository;
import com.emprestimoapi.resource.entidade.BaseResource;

@RestController
@RequestMapping("/parcelas")
public class ParcelaResource extends BaseResource<Parcela>{

	private @Autowired ParcelaRepository parcelaRepository;
//	private @Autowired ApplicationEventPublisher publisher;
//	
//	@GetMapping
//	public List<Parcela> parcelas(){
//		return parcelaRepository.findAll();
//	}
//	
//	@PostMapping
//	public ResponseEntity<Parcela> criar(@Valid @RequestBody Parcela parcela, HttpServletResponse response){
//		Parcela parcelaSalva = parcelaRepository.save(parcela);
//		publisher.publishEvent(new RecursoCriadoEvent(this, response, parcelaSalva.getId()));
//		return ResponseEntity.status(HttpStatus.CREATED).body(parcelaSalva);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<Parcela> buscarPeloCodigo(@PathVariable Long id){
//		Parcela parcela = parcelaRepository.findOne(id);
//		return parcela != null ? ResponseEntity.ok(parcela) : ResponseEntity.notFound().build();
//	}

	@Override
	public BaseRepository<Parcela, Long> repository() {
		return parcelaRepository;
	}
}
