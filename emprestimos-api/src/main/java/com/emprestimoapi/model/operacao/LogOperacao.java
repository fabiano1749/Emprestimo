package com.emprestimoapi.model.operacao;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.emprestimoapi.model.entidade.EntidadeBase;
import com.emprestimoapi.model.entidade.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="log_operacao")
public class LogOperacao extends EntidadeBase{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnoreProperties("logs")
	@ManyToOne
	@JoinColumn(name="id_operacao")
	private Operacao operacao;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@Column(name="data_reg")
	private LocalDateTime dataReg;
	
	private String descricao;

	public LogOperacao() {
		this.dataReg = LocalDateTime.now();
	}
	
	public LogOperacao(Operacao operacao, Usuario usuario, String descricao) {
		this();
		this.operacao = operacao;
		this.usuario = usuario;
		this.descricao = descricao;
	}

	@Override
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getDataReg() {
		return dataReg;
	}

	public void setDataReg(LocalDateTime dataReg) {
		this.dataReg = dataReg;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
