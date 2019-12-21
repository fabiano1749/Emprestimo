package com.emprestimoapi.model.operacao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Extrato {

	private LocalDate inicio;
	
	private LocalDate fim;
	
	private Conta conta;
	
	List<ItemExtrato> itens;
	
	List<Operacao> operacoes;
	
	List<Parcela> parcelas;

	public Extrato(LocalDate inicio, LocalDate fim, Conta conta, List<Operacao> operacoes, List<Parcela> parcelas) {
		this.inicio = inicio;
		this.fim = fim;
		this.conta = conta;
		this.operacoes = operacoes;
		this.parcelas = parcelas;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public LocalDate getFim() {
		return fim;
	}

	public Conta getConta() {
		return conta;
	}

	public List<ItemExtrato> getItens() {
		return this.itens;	
	}

	public List<ItemExtrato> getItensOrdenados() {
		if(Optional.ofNullable(itens).isPresent()) {
			return itens.stream().sorted((i1, i2) -> i1.getData().compareTo(i2.getData())).collect(Collectors.toList());
		}
		return itens;
	}
	
	public List<Operacao> getOperacoes() {
		return operacoes;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void criaItens() {
		this.itens = new ArrayList<ItemExtrato>();

		for(Parcela p : this.parcelas) {
			p.setaItensExtrato(this.itens);
		}
		
		for(Operacao o : this.operacoes) {
			o.setaItensExtrato(this.itens);
		}
	}
	
	public ExtratoResumo getExtratoResumo() {
		double entrada = getItens().stream().filter(i -> i.getTipo().equals(TipoItemExtrato.ENTRADA)).mapToDouble(i -> i.getValor().doubleValue()).reduce(0.0, Double::sum);
		double saida = getItens().stream().filter(i -> i.getTipo().equals(TipoItemExtrato.SAIDA)).mapToDouble(i -> i.getValor().doubleValue()).reduce(0.0, Double::sum);
		double saldo = entrada + saida;
		return new ExtratoResumo(getItensOrdenados(), entrada, saida, saldo);
	}
}
