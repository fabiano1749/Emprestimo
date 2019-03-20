package com.emprestimoapi.service.entidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.entidade.TipoUsuario;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.TipoUsuarioRepository;

@Service
public class TipoUsuarioService extends BaseService<TipoUsuario>{

	private @Autowired TipoUsuarioRepository tipoUsuarioRepository;

	@Override
	public BaseRepository<TipoUsuario, Long> repository() {
		return tipoUsuarioRepository;
	}
}
