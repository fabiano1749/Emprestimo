package com.emprestimoapi.repository.operacao;

import java.time.LocalDate;
import java.util.List;

import com.emprestimoapi.model.operacao.Conta;
import com.emprestimoapi.model.operacao.Operacao;

public interface OperacaoRepositoryQuery {
	
	List<Operacao> operacaoExtrato(LocalDate inicio, LocalDate fim, Conta conta);
}
