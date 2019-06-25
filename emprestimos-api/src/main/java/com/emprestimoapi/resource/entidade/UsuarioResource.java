package com.emprestimoapi.resource.entidade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.entidade.Usuario;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.UsuarioRepository;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.entidade.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource extends BaseResource<Usuario>{

	private @Autowired UsuarioRepository usuarioRepository;
	private @Autowired UsuarioService service;
	

	@Override
	public BaseRepository<Usuario, Long> repository() {
		return usuarioRepository;
	}

	@Override
	public BaseService<Usuario> service() {
		return service;
	}
}
