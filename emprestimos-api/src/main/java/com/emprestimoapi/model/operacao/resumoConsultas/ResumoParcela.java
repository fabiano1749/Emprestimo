package com.emprestimoapi.model.operacao.resumoConsultas;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResumoParcela {
	
	private Long id;
	private int numero;
	private LocalDate  vencimento;
	private LocalDate  recebimento;
	private BigDecimal valorRecebido;
	private Long idStatus;
	private String status;
	public String observacao;
	private BigDecimal valorPrevisto;
	private String cliente;
	private Long idCliente;
	private Long idEmprestimo;
	private Long idStatusEmprestimo;
	private Long idConta;
	private String nomeConta;
	
	public ResumoParcela() {}
	
	public ResumoParcela(Long id, int numero, LocalDate vencimento, LocalDate recebimento,
		BigDecimal valorRecebido, Long idStatus, String status, String observacao, BigDecimal valorPrevisto, 
		String cliente, Long idCliente, Long idEmprestimo, Long idStatusEmprestimo, Long idConta, String nomeConta) {
		super();
		this.id = id;
		this.numero = numero;
		this.vencimento = vencimento;
		this.recebimento = recebimento;
		this.valorRecebido = valorRecebido;
		this.idStatus = idStatus;
		this.status = status;
		this.observacao = observacao;
		this.valorPrevisto = valorPrevisto;
		this.cliente = cliente;
		this.idCliente = idCliente;
		this.idEmprestimo = idEmprestimo;
		this.idStatusEmprestimo = idStatusEmprestimo;
		this.idConta = idConta;
		this.nomeConta = nomeConta;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public LocalDate getVencimento() {
		return vencimento;
	}
	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}
	public LocalDate getRecebimento() {
		return recebimento;
	}
	public void setRecebimento(LocalDate recebimento) {
		this.recebimento = recebimento;
	}
	public BigDecimal getValorRecebido() {
		return valorRecebido;
	}
	public void setValorRecebido(BigDecimal valorRecebido) {
		this.valorRecebido = valorRecebido;
	}
	
	public Long getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public BigDecimal getValorPrevisto() {
		return valorPrevisto;
	}
	public void setValorPrevisto(BigDecimal valorPrevisto) {
		this.valorPrevisto = valorPrevisto;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(Long idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public Long getIdStatusEmprestimo() {
		return idStatusEmprestimo;
	}

	public void setIdStatusEmprestimo(Long idStatusEmprestimo) {
		this.idStatusEmprestimo = idStatusEmprestimo;
	}

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public String getNomeConta() {
		return nomeConta;
	}

	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}
}
