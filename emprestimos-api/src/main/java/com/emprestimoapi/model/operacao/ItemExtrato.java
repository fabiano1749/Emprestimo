package com.emprestimoapi.model.operacao;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ItemExtrato {
	
	private TipoItemExtrato tipo;
	
	private String origem;
	
	private LocalDate data;
	
	private BigDecimal valor;
	
	private String conta;
	
	public ItemExtrato(TipoItemExtrato tipo, String origem, LocalDate data, BigDecimal valor, Conta conta) {
		super();
		this.tipo = tipo;
		this.origem = origem;
		this.data = data;
		this.valor = valor;
		this.conta = conta.getNome();
	}

	public TipoItemExtrato getTipo() {
		return tipo;
	}

	public void setTipo(TipoItemExtrato tipo) {
		this.tipo = tipo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getData() {
		return data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return tipo.equals(TipoItemExtrato.ENTRADA) ? this.valor : this.valor.multiply(new BigDecimal(-1));
	}

	public String getValorFormat() {
		DecimalFormat df = new DecimalFormat("#,###.00");
		return df.format(getValor());
	}
	
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}
}
