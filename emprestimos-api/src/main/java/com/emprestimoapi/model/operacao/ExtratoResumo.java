package com.emprestimoapi.model.operacao;

import java.util.List;

public class ExtratoResumo {

	List<ItemExtrato> itens;
	
	private double entradas;
	
	private double saidas;
	
	private double saldo;

	public ExtratoResumo(List<ItemExtrato> itens, double entradas, double saidas, double saldo) {
		this.itens = itens;
		this.entradas = entradas;
		this.saidas = saidas;
		this.saldo = saldo;
	}

	public List<ItemExtrato> getItens() {
		return itens;
	}

	public double getEntradas() {
		return entradas;
	}

	public double getSaidas() {
		return saidas;
	}

	public double getSaldo() {
		return saldo;
	}
	
}
