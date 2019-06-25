package com.emprestimoapi.resource.entidade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.entidade.Permissao;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.PermissaoRepository;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.entidade.PermissaoService;

@RestController
@RequestMapping("/permissoes")
public class PermissaoResource extends BaseResource<Permissao>{

	private @Autowired PermissaoRepository permissaoRepository;
	private @Autowired PermissaoService service;
	

	@Override
	public BaseRepository<Permissao, Long> repository() {
		return permissaoRepository;
	}


	@Override
	public BaseService<Permissao> service() {
		return service;
	}
	
	
}
