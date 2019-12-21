package com.emprestimoapi.model.operacao;

public enum TipoItemExtrato {
	ENTRADA("Entrada"),
	SAIDA("Saída");
	
	private String descricao;
	
	TipoItemExtrato(String descricao){
		this.descricao = descricao;
	}

	public String getSescricao() {
		return descricao;
	}
}
