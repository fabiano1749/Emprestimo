package com.emprestimoapi.repository.filter;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.emprestimoapi.model.operacao.Conta;

public class RenegociarParcela {
	
	private Long idParcela;

	private BigDecimal jurosRecebido;
	
	private BigDecimal novoValorParcela;
	
	private String proximoVencimento;
	
	private String observacao;
	
	private Long idConta;
	
	private Conta conta;
	

	public Long getIdParcela() {
		return idParcela;
	}

	public void setIdParcela(Long idParcela) {
		this.idParcela = idParcela;
	}

	public BigDecimal getJurosRecebido() {
		return jurosRecebido;
	}

	public void setJurosRecebido(BigDecimal jurosRecebido) {
		this.jurosRecebido = jurosRecebido;
	}

	public BigDecimal getNovoValorParcela() {
		return novoValorParcela;
	}

	public void setNovoValorParcela(BigDecimal novoValorParcela) {
		this.novoValorParcela = novoValorParcela;
	}

	public LocalDate getProximoVencimento() {
		return  this.proximoVencimento != null ? LocalDate.parse(this.proximoVencimento) : LocalDate.now();
	}

	public void setProximoVencimento(String proximoVencimento) {
		this.proximoVencimento = proximoVencimento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
