package com.emprestimoapi.repository.operacao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emprestimoapi.model.operacao.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{

}
