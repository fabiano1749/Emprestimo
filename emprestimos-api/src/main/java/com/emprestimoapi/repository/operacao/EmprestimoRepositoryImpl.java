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

import com.emprestimoapi.model.operacao.Emprestimo;
import com.emprestimoapi.model.operacao.resumoConsultas.ResumoEmprestimo;
import com.emprestimoapi.repository.filter.EmprestimoFilter;

public class EmprestimoRepositoryImpl implements EmprestimoRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<ResumoEmprestimo> filtrarResumo(EmprestimoFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoEmprestimo> criteria = builder.createQuery(ResumoEmprestimo.class);
		Root<Emprestimo> root = criteria.from(Emprestimo.class);
		
		Predicate[] predicates = criarRestricoes(filtro, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.construct(ResumoEmprestimo.class, 
				root.get("id"),
				root.get("dataOperacao"),
				root.get("valor"),
				root.get("status").get("nome"),
				root.get("cliente").get("nome"),
				root.get("usuario").get("nome")));
		
		
		criteria.orderBy(builder.asc(root.get("cliente").get("nome")));
		TypedQuery<ResumoEmprestimo> query = manager.createQuery(criteria);
		return query.getResultList();
	}
	
	
	private Predicate[] criarRestricoes(EmprestimoFilter filtro, CriteriaBuilder builder, Root<Emprestimo> root) {
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if( !StringUtils.isEmpty(filtro.getCliente()) ) {
			predicates.add(builder.like(builder.lower(root.get("cliente").get("nome")), "%" + filtro.getCliente().toLowerCase() + "%"));
		}
		
		if(filtro.getInicio() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("dataOperacao"), filtro.dataInicio()));
		}
		
		if(filtro.getFim() != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("dataOperacao"), filtro.dataFim()));
		}
		
		if(filtro.getIdStatus() != null) {
			predicates.add(builder.equal(root.get("status").get("id"), filtro.getIdStatus()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
}
