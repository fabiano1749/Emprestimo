package com.emprestimoapi.repository.operacao;


import com.emprestimoapi.model.operacao.Operacao;
import com.emprestimoapi.repository.Entidade.BaseRepository;

public interface OperacaoRepository extends BaseRepository<Operacao, Long>  , OperacaoRepositoryQuery{

}
