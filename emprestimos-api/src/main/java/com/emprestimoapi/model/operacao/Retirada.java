package com.emprestimoapi.model.operacao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.emprestimoapi.model.entidade.Usuario;

@Entity
@DiscriminatorValue("retirada")
public class Retirada extends Operacao{
	
	@ManyToOne
	@JoinColumn(name="id_motivo_operacao")
	private TipoEntrada motivoOperacao;

	@ManyToOne
	@JoinColumn(name="id_beneficiario")
	private Usuario beneficiario;

	public TipoEntrada getMotivoOperacao() {
		return motivoOperacao;
	}

	public void setMotivoOperacao(TipoEntrada motivoOperacao) {
		this.motivoOperacao = motivoOperacao;
	}

	public Usuario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Usuario beneficiario) {
		this.beneficiario = beneficiario;
	}
}
