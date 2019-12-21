package com.emprestimoapi.repository.operacao;

import java.util.List;
import com.emprestimoapi.model.operacao.resumoConsultas.ResumoEmprestimo;
import com.emprestimoapi.repository.filter.EmprestimoFilter;

public interface EmprestimoRepositoryQuery {
	public List<ResumoEmprestimo> filtrarResumo(EmprestimoFilter filtro);
}
