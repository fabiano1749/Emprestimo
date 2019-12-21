package com.emprestimoapi.repository.Entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.emprestimoapi.model.entidade.Cliente;
import com.emprestimoapi.model.entidade.Endereco;
import com.emprestimoapi.repository.filter.ClienteFilter;

public class ClienteRepositoryImpl implements ClienteRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cliente> filtrar(ClienteFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
		Root<Cliente> root = criteria.from(Cliente.class);
		Join<Cliente, Endereco> endereco = root.joinList("enderecos", JoinType.LEFT);
		
		Predicate[] predicates = criarRestricoes(filtro, builder, root, endereco);
		criteria.where(predicates);
		
		TypedQuery<Cliente> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(ClienteFilter filtro, CriteriaBuilder builder, Root<Cliente> root, Join<Cliente, Endereco> endereco) {
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(!StringUtils.isEmpty(filtro.getNome())) {
			predicates.add(builder.like(builder.lower(root.get("nome")), "%" + filtro.getNome().toLowerCase() + "%"));
			
		}
		
		if(filtro.getCidade() != null) {
			predicates.add(builder.like(builder.lower(endereco.get("cidade").get("nome")), "%" + filtro.getCidade().toLowerCase() + "%"));	
		}
		
		if(filtro.getEstado() != null) {
			predicates.add(builder.like(builder.lower(endereco.get("cidade").get("estado").get("nome")), "%" + filtro.getEstado().toLowerCase() + "%"));
		}
		
		if(filtro.getStatus() != null) {
			predicates.add(builder.equal(root.get("status").get("nome"), filtro.getStatus()));
		}
		
		if(filtro.getUsuario() != null) {
			predicates.add(builder.equal(root.get("usuario").get("nome"), filtro.getUsuario()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
