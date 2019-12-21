package com.emprestimoapi.repository.operacao;

import java.time.LocalDate;
import java.util.List;

import com.emprestimoapi.model.operacao.Conta;
import com.emprestimoapi.model.operacao.Parcela;
import com.emprestimoapi.model.operacao.resumoConsultas.ResumoParcela;
import com.emprestimoapi.model.operacao.resumoConsultas.ResumoParcelaRelatorio;
import com.emprestimoapi.repository.filter.ParcelaFilter;

public interface ParcelaRepositoryQuery {

	public List<Parcela> filtrar(ParcelaFilter filtro);
	
	public List<ResumoParcela> filtrarResumo(ParcelaFilter filtro);
	
	public List<ResumoParcelaRelatorio> filtrarResumoRelatorio(ParcelaFilter filtro);
	
	public List<Parcela> parcelasExtrato(LocalDate inicio, LocalDate fim, Conta conta);
	
}
