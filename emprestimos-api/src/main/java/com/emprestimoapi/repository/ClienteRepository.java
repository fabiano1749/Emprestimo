package com.emprestimoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emprestimoapi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
