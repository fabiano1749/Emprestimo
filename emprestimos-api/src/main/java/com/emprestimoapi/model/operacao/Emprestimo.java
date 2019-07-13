package com.emprestimoapi.model.operacao;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.emprestimoapi.model.entidade.Cliente;
import com.emprestimoapi.model.entidade.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DiscriminatorValue("emprestimo")
public class Emprestimo extends Operacao{
	
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

	@JsonIgnoreProperties("emprestimo")
	@Valid
	@OneToMany(mappedBy= "emprestimo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Parcela> parcelas;
	
	
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
	
	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	public static List<Status> statusUsados() {
		List<Status> status = Arrays.asList(Status.ABERTO, Status.EM_ANDAMENTO, Status.CANCELADO, Status.FECHADO);
		return status;
	}
}
