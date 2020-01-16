package com.emprestimoapi.model.operacao;

import java.text.DecimalFormat;
import java.util.List;

public class ExtratoResumo {

	List<ItemExtrato> itens;
	
	private Double entradas;
	
	private Double saidas;
	
	private Double saldo;
	
	private DecimalFormat df = new DecimalFormat("#,###.00");

	public ExtratoResumo(List<ItemExtrato> itens, Double entradas, Double saidas, Double saldo) {
		this.itens = itens;
		this.entradas = entradas;
		this.saidas = saidas;
		this.saldo = saldo;
	}

	public List<ItemExtrato> getItens() {
		return itens;
	}

	public String getEntradas() {
		return this.entradas != null ? df.format(entradas) : "0,00";
	}

	public String getSaidas() {
		return this.saidas != null ? df.format(saidas) : "0,00";
	}

	public String getSaldo() {
		return this.saldo != null ? df.format(saldo) : "0,00";
	}
	
}
