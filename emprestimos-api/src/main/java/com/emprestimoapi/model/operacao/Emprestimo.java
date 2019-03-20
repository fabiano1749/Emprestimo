package com.emprestimoapi.model.operacao;

import java.math.BigDecimal;

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

import com.emprestimoapi.model.entidade.Cliente;
import com.emprestimoapi.model.entidade.EntidadeBase;

@Entity
@Table(name ="emprestimo")
public class Emprestimo extends EntidadeBase{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "juros_valor")
	private BigDecimal jurosValor;
	
	@NotNull
	@Column(name = "juros_percentual")
	private BigDecimal jurosPercentual;
	
	@NotNull
	@Column(name = "quant_parcelas")
	private int quantParcelas;
	
	@NotNull
	@Column(name = "intervalo_entre_parcelas")
	private int intervaloEntreParcelas;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	@OneToOne
	@JoinColumn(name="id_operacao")
	private Operacao operacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getJurosValor() {
		return jurosValor;
	}

	public void setJurosValor(BigDecimal jurosValor) {
		this.jurosValor = jurosValor;
	}

	public BigDecimal getJurosPercentual() {
		return jurosPercentual;
	}

	public void setJurosPercentual(BigDecimal jurosPercentual) {
		this.jurosPercentual = jurosPercentual;
	}

	public int getQuantParcelas() {
		return quantParcelas;
	}

	public void setQuantParcelas(int quantParcelas) {
		this.quantParcelas = quantParcelas;
	}

	public int getIntervaloEntreParcelas() {
		return intervaloEntreParcelas;
	}

	public void setIntervaloEntreParcelas(int intervaloEntreParcelas) {
		this.intervaloEntreParcelas = intervaloEntreParcelas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}
	
}
