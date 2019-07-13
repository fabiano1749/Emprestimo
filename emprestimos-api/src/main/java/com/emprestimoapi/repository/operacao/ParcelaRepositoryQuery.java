package com.emprestimoapi.repository.operacao;

import java.util.List;

import com.emprestimoapi.model.operacao.Parcela;
import com.emprestimoapi.model.operacao.resumoConsultas.ResumoParcela;
import com.emprestimoapi.repository.filter.ParcelaFilter;

public interface ParcelaRepositoryQuery {

	public List<Parcela> filtrar(ParcelaFilter filtro);
	
	public List<ResumoParcela> filtrarResumo(ParcelaFilter filtro);
}
