package com.emprestimoapi.repository.operacao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emprestimoapi.model.operacao.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, Long>{

}
