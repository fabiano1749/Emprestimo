package com.emprestimoapi.model.entidade;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DiscriminatorValue("usuario")
public class Usuario extends Entidade{
		
	@NotNull
	private String senha;
	
	@NotNull
	private String username;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_usuario")
	private TipoUsuario tipo;
	
	@JsonIgnoreProperties("usuario")
	@Valid
	@OneToMany(mappedBy= "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Cliente> clientes;
	
	
	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public static List<Status> statusUsados() {
		List<Status> status = Arrays.asList(Status.ATIVO, Status.INATIVO);
		return status;
	}
}
