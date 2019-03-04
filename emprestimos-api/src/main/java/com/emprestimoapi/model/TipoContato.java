package com.emprestimoapi.model;

public enum TipoContato {
	PESSOAL("Pessoal"),
	COMERCIAL("Comercial");
	
	private String descricao;
	
	TipoContato(String descricao){
		this.descricao = descricao;
	}

	public String getSescricao() {
		return descricao;
	}
}
