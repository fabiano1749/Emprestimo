package com.emprestimoapi.model.operacao.resumoConsultas;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResumoEmprestimo {
	
	private Long id;
	private LocalDate  dataOperacao;
	private BigDecimal valor;
	private String status;
	private String cliente;
	private String usuario;
	
	public ResumoEmprestimo() {}
	
	public ResumoEmprestimo(Long id, LocalDate dataOperacao, BigDecimal valor, String status, String cliente, String usuario) {
		super();
		this.id = id;
		this.dataOperacao = dataOperacao;
		this.valor = valor;
		this.status = status;
		this.cliente = cliente;
		this.usuario = usuario;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataOperacao() {
		return dataOperacao;
	}

	public void setDataOperacao(LocalDate dataOperacao) {
		this.dataOperacao = dataOperacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
