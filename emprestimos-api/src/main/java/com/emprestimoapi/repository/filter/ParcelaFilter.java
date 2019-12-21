package com.emprestimoapi.repository.filter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

public class ParcelaFilter {

	private String cliente;
	
	private String inicio;
	
	private String fim;
	
	private String username;
	
	private Long id;

	private Long idStatus;
	
	private Long idConta;
	
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFim() {
		return fim;
	}

	public void setFim(String fim) {
		this.fim = fim;
	}

	public LocalDate converteData(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(data,formatter);
	}
	
	public LocalDate dataInicio() {
		return !StringUtils.isEmpty(inicio) ? converteData(getInicio()) : null;
	}
	
	public LocalDate dataFim() {
		return !StringUtils.isEmpty(fim) ? converteData(getFim()) : null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

}
