package com.emprestimoapi.repository.operacao;


import com.emprestimoapi.model.operacao.Emprestimo;
import com.emprestimoapi.repository.Entidade.BaseRepository;

public interface EmprestimoRepository extends BaseRepository<Emprestimo, Long>, EmprestimoRepositoryQuery{

}
