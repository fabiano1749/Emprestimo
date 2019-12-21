package com.emprestimoapi.repository.Entidade;

import java.util.List;

import com.emprestimoapi.model.entidade.Cliente;
import com.emprestimoapi.repository.filter.ClienteFilter;

public interface ClienteRepositoryQuery {
	public List<Cliente> filtrar(ClienteFilter filtro);
}
