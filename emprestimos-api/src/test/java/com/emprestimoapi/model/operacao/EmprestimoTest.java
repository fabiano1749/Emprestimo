package com.emprestimoapi.model.operacao;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;



public class EmprestimoTest {

	/*
	@Test
	public void testParcelaComMaiorNumero_ListaDeEmprestimoPopulada() {
		//Criação do cenário
		Emprestimo emprestimo = new Emprestimo();
		Parcela p1 = new Parcela();
		Parcela p2 = new Parcela();
		p1.setNumero(1);
		p2.setNumero(2);
		p1.setId(1L);
		p2.setId(2L);
		List<Parcela> parcelas = Arrays.asList(p1, p2);
		emprestimo.setParcelas(parcelas);
		//Execução
		Parcela p = emprestimo.parcelaComMaiorNumero();
		
//		Verificação
		assertEquals(p2, p);
	}
	*/
	@Test
	public void testParcelaComMaiorNumero_ListaDeEmprestimoNaoPopulada() {
		//Criação do cenário
		Emprestimo emprestimo = new Emprestimo();

		//Execução
		Parcela p = emprestimo.parcelaComMaiorNumero();
		
		//Verificação
		assertNull(p);
	}
	
}
