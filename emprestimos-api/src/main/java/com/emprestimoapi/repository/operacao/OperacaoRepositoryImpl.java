package com.emprestimoapi.repository.operacao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.emprestimoapi.model.operacao.Conta;
import com.emprestimoapi.model.operacao.Operacao;

public class OperacaoRepositoryImpl implements OperacaoRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	public List<Operacao> operacaoExtrato(LocalDate inicio, LocalDate fim, Conta conta){
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Operacao> criteria = builder.createQuery(Operacao.class);
		Root<Operacao> root = criteria.from(Operacao.class);
		
		Predicate[] predicates = criarRestricoesItensExtrato(inicio, fim, conta, builder, root);
		criteria.where(predicates);
		TypedQuery<Operacao> query = manager.createQuery(criteria);
		return query.getResultList();
	}
	
	private Predicate[] criarRestricoesItensExtrato(LocalDate inicio, LocalDate fim, Conta conta, CriteriaBuilder builder, Root<Operacao> root) {
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if( conta != null ) {
			predicates.add(builder.equal(root.get("conta"), conta));
		}
		
		if(inicio != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("dataOperacao"), inicio));
		}
		
		if(fim != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("dataOperacao"), fim));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
}
