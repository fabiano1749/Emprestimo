package com.emprestimoapi.repository.Entidade;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emprestimoapi.model.entidade.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
