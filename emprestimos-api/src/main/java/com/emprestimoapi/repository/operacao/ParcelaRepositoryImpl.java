package com.emprestimoapi.repository.operacao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.emprestimoapi.model.operacao.Parcela;
import com.emprestimoapi.model.operacao.resumoConsultas.ResumoParcela;
import com.emprestimoapi.repository.filter.ParcelaFilter;

public class ParcelaRepositoryImpl implements ParcelaRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Parcela> filtrar(ParcelaFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Parcela> criteria = builder.createQuery(Parcela.class);
		Root<Parcela> root = criteria.from(Parcela.class);
		
		Predicate[] predicates = criarRestricoes(filtro, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Parcela> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(ParcelaFilter filtro, CriteriaBuilder builder, Root<Parcela> root) {
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if( !StringUtils.isEmpty(filtro.getCliente()) ) {
			predicates.add(builder.like(builder.lower(root.get("emprestimo").get("cliente").get("nome")), "%" + filtro.getCliente().toLowerCase() + "%"));
		}
		
		if(filtro.getInicio() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("vencimento"), filtro.dataInicio()));
		}
		
		if(filtro.getFim() != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("vencimento"), filtro.dataFim()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	
	@Override
	public List<ResumoParcela> filtrarResumo(ParcelaFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoParcela> criteria = builder.createQuery(ResumoParcela.class);
		Root<Parcela> root = criteria.from(Parcela.class);
		
		Predicate[] predicates = criarRestricoes(filtro, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.construct(ResumoParcela.class, 
				root.get("id"),
				root.get("numero"),
				root.get("vencimento"),
				root.get("recebimento"),
				root.get("valorRecebido"),
				root.get("status").get("nome"),
				root.get("observacao"),
				root.get("valorPrevisto"),
				root.get("emprestimo").get("cliente").get("nome")));
		
		TypedQuery<ResumoParcela> query = manager.createQuery(criteria);
		return query.getResultList();
	}
	
	

}
