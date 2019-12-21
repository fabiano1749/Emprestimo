package com.emprestimoapi.model.entidade;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@DiscriminatorValue("cliente")
public class Cliente extends Entidade{
	
	@Column(name="nome_comercio")
	@NotNull
	private String nomeComercio;
	
	@JsonIgnoreProperties("clientes")
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public String getNomeComercio() {
		return nomeComercio;
	}

	public void setNomeComercio(String nomeComercio) {
		this.nomeComercio = nomeComercio;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static List<Status> statusUsados() {
		List<Status> status = Arrays.asList(Status.ATIVO, Status.INATIVO);
		return status;
	}
	

	public EnderecoContatoCliente enderecoContato() {
		EnderecoContatoCliente  e = new EnderecoContatoCliente();
		e.setEndereco(resumoEndereco());
		e.setContato(resumoContato());
		return e;
	}
	
	
	public String resumoEndereco() {
		String endereco = "";
		if(getEnderecos() != null && !getEnderecos().isEmpty() ) {
			endereco = getEnderecos().get(0).resumo();
		}
		return endereco;
	}
	
	public String resumoContato() {
		String contato = "";
		if(getContatos() != null && !getContatos().isEmpty()) {
			contato = getContatos().get(0).resumo();
		}
		return contato;	
	}
}
