package com.emprestimoapi.model.operacao.resumoConsultas;


import java.util.Date;

import com.emprestimoapi.model.entidade.Cliente;
import com.emprestimoapi.model.operacao.Parcela;

public class ResumoParcelaRelatorio {
	
	private Cliente cliente;
	private Parcela parcela;
	
	private String nomeCliente;
	private String endereco;
	private String contato;
	private Integer numParcela;
	private Date vencimento;
	private String status;
	private Double valor;
	
	
	public ResumoParcelaRelatorio(Cliente cliente, Parcela parcela) {
		this.cliente = cliente;
		this.parcela = parcela;
		setaValores();
	}
	
	public void setaValores() {
		this.nomeCliente = this.cliente.getNome();
		this.endereco = this.cliente.resumoEndereco();
		this.contato = this.cliente.resumoContato();
		this.numParcela = this.parcela.getNumero();
		this.vencimento = java.sql.Date.valueOf(parcela.getVencimento());
		this.status = this.parcela.getStatus().getNome();
		this.valor = this.parcela.getValorPrevisto().doubleValue();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Parcela getParcela() {
		return parcela;
	}

	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Integer getNumParcela() {
		return numParcela;
	}

	public void setNumParcela(Integer numParcela) {
		this.numParcela = numParcela;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
