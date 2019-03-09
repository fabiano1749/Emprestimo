package com.emprestimoapi.model.operacao;

public enum TipoOperacao {
	EMPRESTIMO("Empréstimo"),
	RETIRADA("Retirada"),
	ENTRADA("Entrada");
	
	private String descricao;
	
	private TipoOperacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
