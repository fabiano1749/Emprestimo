package com.emprestimoapi.resource.entidade;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimoapi.model.entidade.Estado;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.EstadoRepository;
import com.emprestimoapi.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoResource extends BaseResource<Estado>{

	private @Autowired EstadoRepository estadoRepository;
	private @Autowired EstadoService estadoService;
	

//	@PostMapping
//	public ResponseEntity<Estado> criar(@Valid @RequestBody Estado estado, HttpServletResponse response){
//		Estado estadoSalvo = estadoRepository.save(estado);
//		publisher.publishEvent(new RecursoCriadoEvent(this, response, estadoSalvo.getId()));
//		return ResponseEntity.status(HttpStatus.CREATED).body(estadoSalvo);
//	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<Estado> buscarPeloCodigo(@PathVariable Long id){
//		Estado estado = estadoRepository.findOne(id);
//		return estado != null ? ResponseEntity.ok(estado) : ResponseEntity.notFound().build();
//	}
//	
	@PutMapping("/{id}")
	public ResponseEntity<Estado> atualizar(@PathVariable Long id, @Valid @RequestBody Estado estado){
		return ResponseEntity.ok(estadoService.atualizar(id, estado));
	}

	@Override
	public BaseRepository<Estado, Long> repository() {
		return estadoRepository;
	}
	
}
