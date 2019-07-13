package com.emprestimoapi.model.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="status")
public class Status extends EntidadeBase{

	public static final Long STATUS_ABERTO = 1L;
	public static final Long STATUS_ATIVO = 2L;
	public static final Long STATUS_FECHADO = 3L;
	public static final Long STATUS_CANCELADO = 4L;
	public static final Long STATUS_INATIVO = 5L;
	public static final Long STATUS_AUTORIZADO = 6L;
	public static final Long STATUS_EM_ANDAMENTO = 7L;
	public static final Long STATUS_RENEGOCIADO = 8L;
	
	public static final Status ABERTO = new Status(STATUS_ABERTO);
	public static final Status ATIVO = new Status(STATUS_ATIVO);
	public static final Status FECHADO = new Status(STATUS_FECHADO);
	public static final Status CANCELADO = new Status(STATUS_CANCELADO);
	public static final Status INATIVO = new Status(STATUS_INATIVO);
	public static final Status AUTORIZADO = new Status(STATUS_AUTORIZADO);
	public static final Status EM_ANDAMENTO = new Status(STATUS_EM_ANDAMENTO);
	public static final Status RENEGOCIADO = new Status(STATUS_RENEGOCIADO);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=6, max=30)
	private String nome;
	
	@NotNull
	private int numero;
	
	@NotNull
	@Size(max=200)
	private String descricao;

	public Status() {
		
	}
	
	public Status(Long idStatus) {
		id = idStatus;
		nome = getNome(id);
	}
	
	public Status(String nome, int numero, String descricao) {
		this.nome = nome;
		this.numero = numero;
		this.descricao = descricao;
	}
	
	public static String getNome(Long id) {
		if(STATUS_ABERTO.equals(id)) {
			return "Aberto";
		}
		else if(STATUS_ATIVO.equals(id)) {
			return "Ativo";
		}
		else if(STATUS_FECHADO.equals(id)) {
			return "Fechado";
		}
		else if(STATUS_CANCELADO.equals(id)) {
			return "Cancelado";
		}
		else if(STATUS_INATIVO.equals(id)) {
			return "Inativo";
		}
		else if(STATUS_AUTORIZADO.equals(id)) {
			return "Autorizado";
		}
		else if(STATUS_EM_ANDAMENTO.equals(id)) {
			return "Em andamento";
		}
		else if(STATUS_RENEGOCIADO.equals(id)) {
			return "Renegociado";
		}
		return "Sem status";
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
