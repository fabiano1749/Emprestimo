package com.emprestimoapi.service.operacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.operacao.Emprestimo;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.EmprestimoRepository;
import com.emprestimoapi.service.entidade.BaseService;

@Service
public class EmprestimoService extends BaseService<Emprestimo>{

	private @Autowired EmprestimoRepository emprestimoRepository;

	@Override
	public BaseRepository<Emprestimo, Long> repository() {
		return emprestimoRepository;
	}
}
