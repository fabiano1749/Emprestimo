package com.emprestimoapi.model.operacao;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@DiscriminatorValue("entrada")
public class Entrada extends Operacao{

	@ManyToOne
	@JoinColumn(name="id_motivo_operacao")
	private TipoEntrada motivoOperacao;

	public TipoEntrada getMotivoOperacao() {
		return motivoOperacao;
	}

	public void setMotivoOperacao(TipoEntrada motivoOperacao) {
		this.motivoOperacao = motivoOperacao;
	}

	public void setaItensExtrato(List<ItemExtrato> itens) {
		ItemExtrato item = new ItemExtrato(TipoItemExtrato.ENTRADA, "Entrada" , getDataOperacao(), getValor(), getConta());
		itens.add(item);
	}
}
