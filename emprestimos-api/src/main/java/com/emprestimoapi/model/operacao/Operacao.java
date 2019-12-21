package com.emprestimoapi.model.operacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.emprestimoapi.model.entidade.EntidadeBase;
import com.emprestimoapi.model.entidade.Status;
import com.emprestimoapi.model.entidade.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo", discriminatorType=DiscriminatorType.STRING)
@Table(name="operacao")
public abstract class Operacao extends EntidadeBase{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @Column(name="data_reg")
	private LocalDateTime dataRegistro;
    
    @Column(name="data_operacao")
	private LocalDate dataOperacao;
	
    @NotNull
	private BigDecimal valor;
	
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="id_conta")
	private Conta conta;
	
	@ManyToOne
	@JoinColumn(name="id_status")
	private Status status;

	@JsonIgnoreProperties("operacao")
	@Valid
	@OneToMany(mappedBy="operacao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LogOperacao> logs;
	
	
	public Operacao() {
		dataRegistro = LocalDateTime.now();
		setStatus(Status.ABERTO);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	public LocalDate getDataOperacao() {
		return dataOperacao;
	}

	public void setDataOperacao(LocalDate dataOperacao) {
		this.dataOperacao = dataOperacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public List<LogOperacao> getLogs() {
		if(logs == null) {
			logs = new ArrayList<LogOperacao>();
		}
		return logs;
	}

	public void setLogs(List<LogOperacao> logs) {
		this.logs = logs;
	}

	public static List<Status> statusUsados() {
		List<Status> status = Arrays.asList(Status.ABERTO, Status.AUTORIZADO, Status.CANCELADO, Status.FECHADO);
		return status;
	}
	
	public void geraLog(Usuario usuario, String descricao) {
		getLogs().add(new LogOperacao(this, usuario, descricao));
	}	
	
	public abstract void setaItensExtrato(List<ItemExtrato> itens);
	
}
