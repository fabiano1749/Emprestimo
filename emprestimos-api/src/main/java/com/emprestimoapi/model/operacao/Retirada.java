package com.emprestimoapi.model.operacao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("retirada")
public class Retirada extends Operacao{
	
	@ManyToOne
	@JoinColumn(name="id_motivo_operacao")
	private TipoEntrada motivoOperacao;

	public TipoEntrada getMotivoOperacao() {
		return motivoOperacao;
	}

	public void setMotivoOperacao(TipoEntrada motivoOperacao) {
		this.motivoOperacao = motivoOperacao;
	}
}
