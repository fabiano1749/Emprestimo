package com.emprestimoapi.model.operacao.resumoConsultas;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResumoParcela {
	
	private Long id;
	private int numero;
	private LocalDate  vencimento;
	private LocalDate  recebimento;
	private BigDecimal valorRecebido;
	private String status;
	public String observacao;
	private BigDecimal valorPrevisto;
	private String cliente;
	
	public ResumoParcela() {}
	
	public ResumoParcela(Long id, int numero, LocalDate vencimento, LocalDate recebimento,
		BigDecimal valorRecebido, String status, String observacao, BigDecimal valorPrevisto, String cliente) {
		super();
		this.id = id;
		this.numero = numero;
		this.vencimento = vencimento;
		this.recebimento = recebimento;
		this.valorRecebido = valorRecebido;
		this.status = status;
		this.observacao = observacao;
		this.valorPrevisto = valorPrevisto;
		this.cliente = cliente;
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
}
