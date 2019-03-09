package com.emprestimoapi.repository.operacao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emprestimoapi.model.operacao.Retirada;

public interface RetiradaRepository extends JpaRepository<Retirada, Long> {

}
