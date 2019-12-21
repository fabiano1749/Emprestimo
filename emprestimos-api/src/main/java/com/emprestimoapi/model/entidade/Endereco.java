package com.emprestimoapi.model.entidade;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="endereco")
public class Endereco extends EntidadeBase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private TipoEndereco tipo;
	
	private String cep;
	
	@NotNull
	private String rua;
	
	@NotNull
	private String numero;
	
	private String complemento;
	
	@NotNull
	private String bairro;
	
	private String referencia;
	
	@ManyToOne
	@JoinColumn(name="id_cidade")
	private Cidade cidade;

	@JsonIgnoreProperties("enderecos")
	@ManyToOne
	@JoinColumn(name = "id_entidade")
	private Entidade entidade;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoEndereco getTipo() {
		return tipo;
	}

	public void setTipo(TipoEndereco tipo) {
		this.tipo = tipo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Entidade getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

	@Transient
	public String resumo() {
		String endereco = getTipo().toString();
		if(!StringUtils.isBlank(getCidade().getNome())) {
			endereco = endereco + getCidade().getNome() + " , ";
		}
		if(!StringUtils.isBlank(getBairro())) {
			endereco = endereco + getBairro() +  " , ";
		}
		if(!StringUtils.isBlank(getRua())) {
			endereco = endereco + getRua() +  " , ";
		}
		if(!StringUtils.isBlank(getNumero())) {
			endereco = endereco + getNumero() +  " , ";
		}
		if(!StringUtils.isBlank(getReferencia())) {
			endereco = endereco + getReferencia() +  " , ";
		}
		return  endereco;
	}
}
