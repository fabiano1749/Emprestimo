package com.emprestimoapi.resource.entidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimoapi.model.entidade.Estado;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.EstadoRepository;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.entidade.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoResource extends BaseResource<Estado>{

	private @Autowired EstadoRepository estadoRepository;
	private @Autowired EstadoService estadoService;
	
	@Override
	public BaseRepository<Estado, Long> repository() {
		return estadoRepository;
	}
	
	public BaseService<Estado> service(){
		return estadoService;
	}
	
	
}
