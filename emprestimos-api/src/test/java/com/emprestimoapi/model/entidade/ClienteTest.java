package com.emprestimoapi.model.entidade;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class ClienteTest {
	
	@Test
	public void testPossuiEnderecoComercial_ContemPeloMenosUmEnderecoComercial() {
		//Criação do cenário
		Cliente cliente = new Cliente();
		Endereco endereco1 = new Endereco();
		Endereco endereco2 = new Endereco();
		endereco1.setTipo(TipoEndereco.COMERCIAL);
		endereco2.setTipo(TipoEndereco.PESSOAL);
		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(endereco1);
		enderecos.add(endereco2);
		cliente.setEnderecos(enderecos);
		
		//Execução
		boolean resul = cliente.possuiEnderecoComercial();
		
		//verificação
		assertTrue(resul);
	}
	
		@Test
		public void testPossuiEnderecoComercial_NaoContemEnderoComercial() {
			//Criação do cenário
			Cliente cliente = new Cliente();
			Endereco endereco1 = new Endereco();
			Endereco endereco2 = new Endereco();
			endereco1.setTipo(TipoEndereco.PESSOAL);
			endereco2.setTipo(TipoEndereco.PESSOAL);
			List<Endereco> enderecos = new ArrayList<>();
			enderecos.add(endereco1);
			enderecos.add(endereco2);
			cliente.setEnderecos(enderecos);
			
			//Execução
			boolean resul = cliente.possuiEnderecoComercial();
			
			//verificação
			assertFalse(resul);
		}
		
		@Test
		public void testPossuiEnderecoComercial_ListaDeEnderecoVazia() {
			//Criação do cenário
			Cliente cliente = new Cliente();
			
			//Execução
			boolean resul = cliente.possuiEnderecoComercial();
			
			//verificação
			assertFalse(resul);
		}
	
}
