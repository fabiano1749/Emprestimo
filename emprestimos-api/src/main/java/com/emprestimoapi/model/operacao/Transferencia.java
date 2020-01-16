package com.emprestimoapi.model.operacao;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.envers.Audited;


@Entity
@DiscriminatorValue("transferencia")
@Audited
public class Transferencia extends Operacao{

	@ManyToOne
	@JoinColumn(name="id_contaDestino")
	private Conta contaDestino;

	public Conta getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}

	@Override
	public void setaItensExtrato(List<ItemExtrato> itens) {
		// TODO Auto-generated method stub
		
	}
}
