package com.emprestimoapi.service.operacao;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.entidade.LogSistema;
import com.emprestimoapi.model.entidade.Status;
import com.emprestimoapi.model.operacao.Conta;
import com.emprestimoapi.model.operacao.Emprestimo;
import com.emprestimoapi.model.operacao.Parcela;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.LogSistemaRepository;
import com.emprestimoapi.repository.operacao.ContaRepository;
import com.emprestimoapi.repository.operacao.EmprestimoRepository;
import com.emprestimoapi.service.entidade.BaseService;

@Service
public class EmprestimoService extends BaseService<Emprestimo> {

	private @Autowired EmprestimoRepository emprestimoRepository;
	private @Autowired ContaRepository contaRepository;
	private @Autowired LogSistemaRepository logRepository;
	
	public Emprestimo salvar(Emprestimo emprestimo) {
		if (emprestimo.getId() != null) {
			return atualizar(emprestimo.getId(), emprestimo);
		}
		emprestimo.setUsuario(getUsuarioLogado());
		emprestimo.setStatus(Status.ABERTO);
		emprestimo.geraLog(getUsuarioLogado(), "Registro de emprestimo");
		for (Parcela p : emprestimo.getParcelas()) {
			p.setEmprestimo(emprestimo);
			p.setConta(emprestimo.getConta());
		}
		return emprestimoRepository.save(emprestimo);
	}

	public Emprestimo atualizar(Long id, Emprestimo emprestimo) {
		Optional<Emprestimo> emprestimoSalvo = repository().findById(id);
		Optional<Conta> conta = contaRepository.findById((emprestimo.getConta().getId()));
		
		if (!emprestimoSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		emprestimoSalvo.get().getParcelas().clear();
		emprestimoSalvo.get().getParcelas().addAll(emprestimo.getParcelas());
		emprestimoSalvo.get().getParcelas().forEach(p -> p.setEmprestimo(emprestimoSalvo.get()));
		emprestimoSalvo.get().getParcelas().forEach(p -> p.setConta(conta.get()));
		BeanUtils.copyProperties(emprestimo, emprestimoSalvo.get(), "id", "parcelas", "logs");
		return repository().save(emprestimoSalvo.get());
	}

	@Override
	public BaseRepository<Emprestimo, Long> repository() {
		return emprestimoRepository;
	}

	public void remover(Long id) {
		Emprestimo emprestimo = repository().getOne(id);
		if (emprestimo.getStatus().equals(Status.ABERTO)) {
			LogSistema log = new LogSistema(getUsuarioLogado(), "Exclusão do Empréstimo " + emprestimo.getId() + "no valor de " + emprestimo.getValor() + " para o cliente " + emprestimo.getCliente().getNome() );
			logRepository.save(log);
			emprestimoRepository.deleteById(id);
		}
	}
}
