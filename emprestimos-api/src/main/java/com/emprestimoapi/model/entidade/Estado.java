package com.emprestimoapi.model.entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="estado")
public class Estado extends EntidadeBase{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min=6, max=30)
	private String nome;
	
	@NotBlank
	@Size(min=2, max=2)
	private String sigla;

	@Valid
	@OneToMany(mappedBy="estado", cascade = CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	@Transient
	private List<Cidade> cidades;
	
	public Estado() {
		
	}
	
	public Estado(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
}
