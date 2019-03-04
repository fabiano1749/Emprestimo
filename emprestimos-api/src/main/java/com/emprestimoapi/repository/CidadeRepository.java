package com.emprestimoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emprestimoapi.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
