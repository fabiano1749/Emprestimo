package com.emprestimoapi.repository.operacao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emprestimoapi.model.operacao.Operacao;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {

}
