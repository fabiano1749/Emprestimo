package com.emprestimoapi.repository.filter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

public class ExtratoFilter {
	
	private String inicio;
	
	private String fim;
	
	private Long idConta;

	public LocalDate getInicio() {
		return inicio != null ? converteData(this.inicio) : null;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFim() {
		return fim != null ? converteData(this.fim) : null;
	}

	public void setFim(String fim) {
		this.fim = fim;
	}

	public LocalDate converteData(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(data,formatter);
	}
	
	public LocalDate dataInicio() {
		return !StringUtils.isEmpty(inicio) ? converteData(this.inicio) : null;
	}
	
	public LocalDate dataFim() {
		return !StringUtils.isEmpty(fim) ? converteData(this.fim) : null;
	}

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

}
