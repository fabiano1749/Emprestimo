package com.emprestimoapi.model.operacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import com.emprestimoapi.model.entidade.EntidadeBase;
import com.emprestimoapi.model.entidade.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="parcela")
public class Parcela extends EntidadeBase{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="valor_previsto")
	private BigDecimal valorPrevisto;
	
	
	@Column(name="valor_recebido")
	private BigDecimal valorRecebido;
	
	private int numero;
	
	private LocalDate  vencimento;
	
	private LocalDate  recebimento;
	
	@JsonIgnoreProperties("parcelas")
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

	public LocalDate getVencimento() {
		return vencimento;
	}

	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}

	public LocalDate getRecebimento() {
		return recebimento;
	}

	public void setRecebimento(LocalDate recebimento) {
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
	
	public static List<Status> statusUsados() {
		List<Status> status = Arrays.asList(Status.ABERTO, Status.CANCELADO, Status.FECHADO, Status.RENEGOCIADO);
		return status;
	}
	
}
