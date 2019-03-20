package com.emprestimoapi.model.operacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.emprestimoapi.model.entidade.EntidadeBase;
import com.emprestimoapi.model.entidade.Usuario;

@Entity
@Table(name = "retirada")
public class Retirada extends EntidadeBase{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_tipo")
	private TipoEntrada tipo;
	
	@OneToOne
	@JoinColumn(name="id_operacao")
	private Operacao operacao;

	@ManyToOne
	@JoinColumn(name="id_beneficiario")
	private Usuario beneficiario;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoEntrada getTipo() {
		return tipo;
	}

	public void setTipo(TipoEntrada tipo) {
		this.tipo = tipo;
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public Usuario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Usuario beneficiario) {
		this.beneficiario = beneficiario;
	}
	
}
