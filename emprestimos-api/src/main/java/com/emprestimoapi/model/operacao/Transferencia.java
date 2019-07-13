package com.emprestimoapi.model.operacao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@DiscriminatorValue("transferencia")
public class Transferencia extends Operacao{

	@ManyToOne
	@JoinColumn(name="id_caixa")
	private Conta caixa;

	public Conta getCaixa() {
		return caixa;
	}

	public void setCaixa(Conta caixa) {
		this.caixa = caixa;
	}
}
