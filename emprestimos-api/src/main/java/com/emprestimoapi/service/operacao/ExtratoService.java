package com.emprestimoapi.service.operacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.operacao.Conta;
import com.emprestimoapi.model.operacao.Extrato;
import com.emprestimoapi.model.operacao.ExtratoResumo;
import com.emprestimoapi.model.operacao.Operacao;
import com.emprestimoapi.model.operacao.Parcela;
import com.emprestimoapi.repository.filter.ExtratoFilter;
import com.emprestimoapi.repository.operacao.ContaRepository;
import com.emprestimoapi.repository.operacao.OperacaoRepository;
import com.emprestimoapi.repository.operacao.ParcelaRepository;

@Service
public class ExtratoService {

	private @Autowired ParcelaRepository parcelaRepository;
	private @Autowired OperacaoRepository operacaoRepository;
	private @Autowired ContaRepository contaRepository;
	
	public ExtratoResumo extrato(ExtratoFilter filtro){
		Conta conta = null;
		if(filtro.getIdConta() != null) {
			conta = contaRepository.findById(filtro.getIdConta()).get();
		}
		List<Parcela> parcelas = parcelaRepository.parcelasExtrato(filtro.getInicio(), filtro.getFim(), conta);
		List<Operacao> operacoes = operacaoRepository.operacaoExtrato(filtro.getInicio(), filtro.getFim(), conta);
		Extrato extrato = new Extrato(filtro.getInicio(), filtro.getFim(), conta, operacoes, parcelas);
		extrato.criaItens();
		return extrato.getExtratoResumo();
	}
	
}
