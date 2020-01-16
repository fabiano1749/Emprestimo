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

import org.hibernate.envers.Audited;

import com.emprestimoapi.model.entidade.EntidadeBase;
import com.emprestimoapi.model.entidade.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="log_parcela")
@Audited
public class LogParcela extends EntidadeBase{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnoreProperties("logs")
	@ManyToOne
	@JoinColumn(name="id_parcela")
	private Parcela parcela;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@Column(name="data_reg")
	private LocalDateTime dataReg;
	
	private String descricao;

	public LogParcela() {
		this.dataReg = LocalDateTime.now();
	}
	
	
	public LogParcela(Parcela parcela, Usuario usuario, String descricao) {
		this();
		this.parcela = parcela;
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

	public Parcela getParcela() {
		return parcela;
	}

	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
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
