package com.emprestimoapi.resource.operacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimoapi.model.operacao.ExtratoResumo;
import com.emprestimoapi.repository.filter.ExtratoFilter;
import com.emprestimoapi.service.operacao.ExtratoService;


@RestController
@RequestMapping("/extrato")
public class ExtratoResource{

	private @Autowired ExtratoService extratoService;
	
	@GetMapping("extrato")
	public ExtratoResumo extrato(ExtratoFilter filtro){
		ExtratoResumo resumo = extratoService.extrato(filtro);
		return resumo;
	}
	
}
