package com.emprestimoapi.service.operacao;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.entidade.Status;
import com.emprestimoapi.model.operacao.Emprestimo;
import com.emprestimoapi.model.operacao.Parcela;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.EmprestimoRepository;
import com.emprestimoapi.service.entidade.BaseService;

@Service
public class EmprestimoService extends BaseService<Emprestimo>{

	private @Autowired EmprestimoRepository emprestimoRepository;
	
	public Emprestimo salvar(Emprestimo emprestimo) {
		if(emprestimo.getId() != null) {
			return atualizar(emprestimo.getId(), emprestimo);
		}
		emprestimo.setUsuario(getUsuarioLogado());
		emprestimo.setStatus(Status.ABERTO);
		emprestimo.geraLog(getUsuarioLogado(), "Registro de emprestimo");
		for(Parcela p : emprestimo.getParcelas()) {
			p.setEmprestimo(emprestimo);
			p.setConta(emprestimo.getConta());
		}
		return emprestimoRepository.save(emprestimo);	
	}
	
	
	public Emprestimo atualizar(Long id, Emprestimo emprestimo) {
		Emprestimo emprestimoSalvo = repository().getOne(id);
		if(emprestimoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		emprestimoSalvo.getParcelas().clear();
		emprestimoSalvo.getParcelas().addAll(emprestimo.getParcelas());
		emprestimoSalvo.getParcelas().forEach(p -> p.setEmprestimo(emprestimoSalvo));
		
		BeanUtils.copyProperties(emprestimo, emprestimoSalvo, "id", "parcelas", "logs");
		return repository().save(emprestimoSalvo);
	}
	
	@Override
	public BaseRepository<Emprestimo, Long> repository() {
		return emprestimoRepository;
	}
}
