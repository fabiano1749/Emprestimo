package com.emprestimoapi.model.operacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

import com.emprestimoapi.model.entidade.EntidadeBase;
import com.emprestimoapi.model.entidade.Status;
import com.emprestimoapi.model.entidade.Usuario;
import com.emprestimoapi.repository.filter.RenegociarParcela;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="parcela")
@Audited
public class Parcela extends EntidadeBase{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="valor_previsto")
	private BigDecimal valorPrevisto;
		
	@Column(name="valor_recebido")
	private BigDecimal valorRecebido;
	
	private Integer numero;
	
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
		
	@ManyToOne
	@JoinColumn(name="id_Conta")
	Conta conta;
	
	@JsonIgnoreProperties("parcela")
	@Valid
	@OneToMany(mappedBy="parcela", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LogParcela> logs;
	
	public Parcela() {};
	
	public Parcela(BigDecimal valorPrevisto, BigDecimal valorRecebido, Integer numero, LocalDate vencimento,
			LocalDate recebimento, Emprestimo emprestimo, Parcela parent, Status status, String observacao,
			Conta conta) {
		super();
		this.valorPrevisto = valorPrevisto;
		this.valorRecebido = valorRecebido;
		this.numero = numero;
		this.vencimento = vencimento;
		this.recebimento = recebimento;
		this.emprestimo = emprestimo;
		this.parent = parent;
		this.status = status;
		this.observacao = observacao;
		this.conta = conta;
	}

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
		if(valorPrevisto != null && valorPrevisto.compareTo(BigDecimal.ZERO) < 0) {
			this.valorPrevisto = valorPrevisto.negate();
		}
		else {
			this.valorPrevisto = valorPrevisto;
		}
	}

	public BigDecimal getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(BigDecimal valorRecebido) {
		if(valorRecebido != null && valorRecebido.compareTo(BigDecimal.ZERO) < 0) {
			this.valorRecebido = valorRecebido.negate();
		}
		else {
			this.valorRecebido = valorRecebido;
		}
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
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
	
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public List<LogParcela> getLogs() {
		if(logs == null) {
			logs = new ArrayList<>();
		}
		return logs; 
	}

	public void setLogs(List<LogParcela> logs) {
		this.logs = logs;
	}

	public boolean fechada() {
		return getStatus().equals(Status.FECHADO);
	}
	
	public boolean autorizada() {
		return getStatus().equals(Status.AUTORIZADO);
	}
	
	public boolean renegociada() {
		return getStatus().equals(Status.RENEGOCIADO);
	}
	
	public boolean aberta() {
		return getStatus().equals(Status.ABERTO);
	}
	
	public void geraLog(Usuario usuario) {
		String descricao = "Colocou a parcela no status: " + getStatus().getNome();
		getLogs().add(new LogParcela(this, usuario, descricao));
	}
	
	public void geraLog(Usuario usuario, String descricao) {
		getLogs().add(new LogParcela(this, usuario, descricao));
	}
	
	public static List<Status> statusUsados() {
		List<Status> status = Arrays.asList(Status.ABERTO, Status.CANCELADO, Status.FECHADO, Status.RENEGOCIADO);
		return status;
	}
	
	public void renegociar(RenegociarParcela renegociar, Usuario usuario) {
		Parcela parcelaMaiornumero = this.getEmprestimo().parcelaComMaiorNumero();
		Integer maiorNumero = parcelaMaiornumero != null ? parcelaMaiornumero.getNumero() + 1 : 100;  
		
		
		Parcela p = new Parcela(renegociar.getJurosRecebido(), renegociar.getJurosRecebido(), 
				maiorNumero, LocalDate.now(), LocalDate.now(), getEmprestimo(), this, Status.RENEGOCIADO, 
				renegociar.getObservacao(), renegociar.getConta());
		p.getEmprestimo().getParcelas().add(p);
		p.geraLog(usuario);
		this.setVencimento(renegociar.getProximoVencimento());
		this.setValorPrevisto(renegociar.getNovoValorParcela());
	}
	
	public void setaItensExtrato(List<ItemExtrato> itens) {
		ItemExtrato item = new ItemExtrato(TipoItemExtrato.ENTRADA, "Parcela" , getRecebimento(), getValorPrevisto(), getConta());
		itens.add(item);
	}
}
