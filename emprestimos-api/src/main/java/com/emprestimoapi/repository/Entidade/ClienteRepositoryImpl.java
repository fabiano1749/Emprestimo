package com.emprestimoapi.repository.Entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.emprestimoapi.model.entidade.Cliente;
import com.emprestimoapi.repository.filter.ClienteFilter;

public class ClienteRepositoryImpl implements ClienteRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cliente> filtrar(ClienteFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
		Root<Cliente> root = criteria.from(Cliente.class);
		
		Predicate[] predicates = criarRestricoes(filtro, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Cliente> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(ClienteFilter filtro, CriteriaBuilder builder, Root<Cliente> root) {
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(filtro.getNome() != null || !filtro.getNome().isEmpty()) {
			predicates.add(builder.like(builder.lower(root.get("nome")), "%" + filtro.getNome().toLowerCase() + "%"));
		}
		
		if(filtro.getCidade() != null) {
			predicates.add(builder.equal(root.get("cidade"), filtro.getCidade()));
		}
		
		if(filtro.getEstado() != null) {
			predicates.add(builder.equal(root.get("estado"), filtro.getEstado()));
		}
		
		if(filtro.getStatus() != null) {
			predicates.add(builder.equal(root.get("status"), filtro.getStatus()));
		}
		
		if(filtro.getUsuario() != null) {
			predicates.add(builder.equal(root.get("usuario"), filtro.getUsuario()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
