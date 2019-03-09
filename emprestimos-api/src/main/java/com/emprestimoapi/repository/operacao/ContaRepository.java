package com.emprestimoapi.repository.operacao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emprestimoapi.model.operacao.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{

}
