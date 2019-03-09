package com.emprestimoapi.repository.Entidade;


import org.springframework.data.jpa.repository.JpaRepository;

import com.emprestimoapi.model.entidade.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
