package com.emprestimoapi.service.entidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.entidade.Estado;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.EstadoRepository;

@Service
public class EstadoService extends BaseService<Estado>{

	private @Autowired EstadoRepository estadoRepository;

	@Override
	public BaseRepository<Estado, Long> repository() {
		return estadoRepository;
	}
}
