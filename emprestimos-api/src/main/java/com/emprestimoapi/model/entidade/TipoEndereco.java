package com.emprestimoapi.model.entidade;

public enum TipoEndereco {
	PESSOAL("Pessoal"),
	COMERCIAL("Comercial");
	
	private String descricao;
	
	TipoEndereco(String descricao){
		this.descricao = descricao;
	}

	public String getSescricao() {
		return descricao;
	}
}
