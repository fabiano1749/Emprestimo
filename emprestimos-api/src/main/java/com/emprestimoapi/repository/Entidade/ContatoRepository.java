package com.emprestimoapi.repository.Entidade;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emprestimoapi.model.entidade.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
