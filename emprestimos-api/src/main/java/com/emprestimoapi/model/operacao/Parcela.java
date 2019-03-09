package com.emprestimoapi.model.operacao;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.emprestimoapi.model.entidade.Status;

@Entity
@Table(name="parcela")
public class Parcela {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="valor_previsto")
	private BigDecimal valorPrevisto;
	
	@NotNull
	@Column(name="valor_recebido")
	private BigDecimal valorRecebido;
	
	@NotBlank
	private int numero;
	
	@Temporal(TemporalType.DATE)
	private Date vencimento;
	
	@Temporal(TemporalType.DATE)
	private Date recebimento;
	
	@ManyToOne
	@JoinColumn(name="id_emprestimo")
	private Emprestimo emprestimo;
	
	@OneToOne
	@JoinColumn(name = "id_parent")
	private Parcela parent;
	
	@ManyToOne
	@JoinColumn(name="id_status")
	private Status status;

	public String observacao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorPrevisto() {
		return valorPrevisto;
	}

	public void setValorPrevisto(BigDecimal valorPrevisto) {
		this.valorPrevisto = valorPrevisto;
	}

	public BigDecimal getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(BigDecimal valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public Date getRecebimento() {
		return recebimento;
	}

	public void setRecebimento(Date recebimento) {
		this.recebimento = recebimento;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public Parcela getParent() {
		return parent;
	}

	public void setParent(Parcela parent) {
		this.parent = parent;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}
