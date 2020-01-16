package com.emprestimoapi.model.entidade.resumoConsultas;

public class ResumoCliente {
	private Long id;
	
	private String nome;
	
	private Long idUsuario;
	
	private String usuario;
	
	private Long idStatus;
	
	private String Status;

	public ResumoCliente() {};
	
	public ResumoCliente(Long id, String nome, Long idUsuario, String usuario, Long idStatus, String status) {
		this.id = id;
		this.nome = nome;
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.idStatus = idStatus;
		Status = status;
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

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Long getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}
