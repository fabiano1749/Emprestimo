package com.emprestimoapi.resource.entidade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.entidade.TipoUsuario;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.TipoUsuarioRepository;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.entidade.TipoUsuarioService;

@RestController
@RequestMapping("/tipoUsuarios")
public class TipoUsuarioResource extends BaseResource<TipoUsuario>{

	private @Autowired TipoUsuarioRepository tipoUsuarioRepository;
	private @Autowired TipoUsuarioService service;

	@Override
	public BaseRepository<TipoUsuario, Long> repository() {
		return tipoUsuarioRepository;
	}

	@Override
	public BaseService<TipoUsuario> service() {
		return service;
	}
}
