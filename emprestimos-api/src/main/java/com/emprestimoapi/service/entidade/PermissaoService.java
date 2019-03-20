package com.emprestimoapi.service.entidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.entidade.Permissao;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.PermissaoRepository;

@Service
public class PermissaoService extends BaseService<Permissao>{

	private @Autowired PermissaoRepository permissaoRepository;

	@Override
	public BaseRepository<Permissao, Long> repository() {
		return permissaoRepository;
	}
}
