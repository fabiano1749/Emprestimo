package com.emprestimoapi.resource.entidade;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimoapi.model.entidade.Estado;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.EstadoRepository;
import com.emprestimoapi.service.entidade.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoResource extends BaseResource<Estado>{

	private @Autowired EstadoRepository estadoRepository;
	private @Autowired EstadoService estadoService;
	
	@PutMapping("/{id}")
	public ResponseEntity<Estado> atualizar(@PathVariable Long id, @Valid @RequestBody Estado estado){
		return ResponseEntity.ok(estadoService.atualizar(id, estado));
	}

	@Override
	public BaseRepository<Estado, Long> repository() {
		return estadoRepository;
	}
	
}
