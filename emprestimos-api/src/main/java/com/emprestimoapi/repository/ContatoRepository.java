package com.emprestimoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emprestimoapi.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
