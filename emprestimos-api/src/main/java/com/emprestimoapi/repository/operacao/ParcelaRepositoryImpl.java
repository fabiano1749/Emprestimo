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

import org.apache.commons.lang3.StringUtils;

import com.emprestimoapi.model.entidade.Status;
import com.emprestimoapi.model.operacao.Conta;
import com.emprestimoapi.model.operacao.Parcela;
import com.emprestimoapi.model.operacao.resumoConsultas.ResumoParcela;
import com.emprestimoapi.model.operacao.resumoConsultas.ResumoParcelaRelatorio;
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
		
		if(filtro.getIdStatus() != null) {
			predicates.add(builder.equal(root.get("status").get("id"), filtro.getIdStatus()));
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
				root.get("status").get("id"),
				root.get("status").get("nome"),
				root.get("observacao"),
				root.get("valorPrevisto"),
				root.get("emprestimo").get("cliente").get("nome"),
				root.get("emprestimo").get("cliente").get("id"),
				root.get("emprestimo").get("id"),
				root.get("emprestimo").get("status").get("id"),
				root.get("conta").get("id"),
				root.get("conta").get("nome")
				));
		
		criteria.orderBy(builder.asc(root.get("emprestimo").get("cliente").get("nome")));
		TypedQuery<ResumoParcela> query = manager.createQuery(criteria);
		return query.getResultList();
	}
	
	@Override
	public List<Parcela> parcelasExtrato(LocalDate inicio, LocalDate fim, Conta conta){
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Parcela> criteria = builder.createQuery(Parcela.class);
		Root<Parcela> root = criteria.from(Parcela.class);
		
		Predicate[] predicates = criarRestricoesItensExtrato(inicio, fim, conta, builder, root);
		criteria.where(predicates);
		TypedQuery<Parcela> query = manager.createQuery(criteria);
		return query.getResultList();
	}
	
	private Predicate[] criarRestricoesItensExtrato(LocalDate inicio, LocalDate fim, Conta conta, CriteriaBuilder builder, Root<Parcela> root) {
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if( conta != null ) {
			predicates.add(builder.equal(root.get("conta"), conta));
		}
		
		predicates.add(builder.isNotNull(root.get("recebimento")));
		
		if(inicio != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("recebimento"), inicio));
		}
		
		if(fim != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("recebimento"), fim));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	
	@Override
	public List<ResumoParcelaRelatorio> filtrarResumoRelatorio(ParcelaFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoParcelaRelatorio> criteria = builder.createQuery(ResumoParcelaRelatorio.class);
		Root<Parcela> root = criteria.from(Parcela.class);
		
		Predicate[] predicates = criarRestricoesResumoRelatorio(filtro, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.construct(ResumoParcelaRelatorio.class, 
				root.get("emprestimo").get("cliente"),
				root
				));
		
		TypedQuery<ResumoParcelaRelatorio> query = manager.createQuery(criteria);
		return query.getResultList();
	}
	
	private Predicate[] criarRestricoesResumoRelatorio(ParcelaFilter filtro, CriteriaBuilder builder, Root<Parcela> root) {
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			
			predicates.add(builder.equal(root.get("status"), Status.ABERTO));
			
			if(filtro.dataInicio() != null) {
				predicates.add(builder.greaterThanOrEqualTo(root.get("vencimento"), filtro.dataInicio()));
			}
			
			if(filtro.dataFim() != null) {
				predicates.add(builder.lessThanOrEqualTo(root.get("vencimento"), filtro.dataFim()));
			}
			
			if( !StringUtils.isEmpty(filtro.getCliente()) ) {
				predicates.add(builder.like(builder.lower(root.get("emprestimo").get("cliente").get("nome")), "%" + filtro.getCliente().toLowerCase() + "%"));
			}
			
			if(filtro.getIdStatus() != null) {
				predicates.add(builder.equal(root.get("status").get("id"), filtro.getIdStatus()));
			}
			
			return predicates.toArray(new Predicate[predicates.size()]);
		}

}
