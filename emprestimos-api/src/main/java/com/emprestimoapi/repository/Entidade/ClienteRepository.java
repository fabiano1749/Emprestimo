package com.emprestimoapi.repository.Entidade;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emprestimoapi.model.entidade.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
