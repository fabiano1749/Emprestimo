package com.emprestimoapi.resource.operacao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emprestimoapi.model.operacao.Emprestimo;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.operacao.EmprestimoRepository;
import com.emprestimoapi.resource.entidade.BaseResource;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.operacao.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoResource extends BaseResource<Emprestimo>{

	private @Autowired EmprestimoRepository emprestimoRepository;
	private @Autowired EmprestimoService service;

	@Override
	public BaseRepository<Emprestimo, Long> repository() {
		return emprestimoRepository;
	}

	@Override
	public BaseService<Emprestimo> service() {
		return service;
	}
	
	
}
