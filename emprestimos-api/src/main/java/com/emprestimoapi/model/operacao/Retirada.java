package com.emprestimoapi.model.operacao;


import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@DiscriminatorValue("retirada")
public class Retirada extends Operacao{
	
	@ManyToOne
	@JoinColumn(name="id_motivo_operacao")
	private TipoRetirada motivoOperacao;

	public TipoRetirada getMotivoOperacao() {
		return motivoOperacao;
	}

	public void setMotivoOperacao(TipoRetirada motivoOperacao) {
		this.motivoOperacao = motivoOperacao;
	}

	public void setaItensExtrato(List<ItemExtrato> itens) {
		ItemExtrato item = new ItemExtrato(TipoItemExtrato.SAIDA, "Retirada" , getDataOperacao(), getValor(), getConta());
		itens.add(item);
	}
	
}
