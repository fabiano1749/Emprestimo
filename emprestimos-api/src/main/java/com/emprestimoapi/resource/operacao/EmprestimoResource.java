package com.emprestimoapi.resource.operacao;


import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimoapi.event.RecursoCriadoEvent;
import com.emprestimoapi.model.entidade.Status;
import com.emprestimoapi.model.operacao.Emprestimo;
import com.emprestimoapi.model.operacao.resumoConsultas.ResumoEmprestimo;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.filter.EmprestimoFilter;
import com.emprestimoapi.repository.filter.ParcelaFilter;
import com.emprestimoapi.repository.filter.RenegociarParcela;
import com.emprestimoapi.repository.operacao.EmprestimoRepository;
import com.emprestimoapi.resource.entidade.BaseResource;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.operacao.EmprestimoService;
import com.emprestimoapi.service.operacao.ParcelaService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoResource extends BaseResource<Emprestimo>{

	private @Autowired EmprestimoRepository emprestimoRepository;
	private @Autowired EmprestimoService service;
	private @Autowired ParcelaService parcelaService;
	

	@PostMapping
	public ResponseEntity<Emprestimo> criar(@Valid @RequestBody Emprestimo entidade, HttpServletResponse response){
		Emprestimo entidadeSalva = service.salvar(entidade);
		getPublisher().publishEvent(new RecursoCriadoEvent(this, response, entidadeSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(entidadeSalva);
	}
	
	
	@Override
	public BaseRepository<Emprestimo, Long> repository() {
		return emprestimoRepository;
	}

	@Override
	public BaseService<Emprestimo> service() {
		return service;
	}
	
	@GetMapping("pesquisa")
	public List<ResumoEmprestimo> pesquisar(EmprestimoFilter filtro){
		return emprestimoRepository.filtrarResumo(filtro);
	}
	
	@GetMapping("/status")
	public List<Status> statusUsados(){
		return Emprestimo.statusUsados();
	}
	
	@GetMapping("/buscaPeloId/{id}")
	public Emprestimo buscarPeloId(@PathVariable Long id){
		Emprestimo entidade = emprestimoRepository.findById(id).get();
		return entidade != null ? entidade : null;
	}	
	
	
	@GetMapping("recebeParcela")
	public Emprestimo recebeParcela(ParcelaFilter filtro) {
		parcelaService.atualizarStatus(filtro.getId(), filtro.getIdConta());
		return parcelaService.emprestimo(filtro.getId());
	}
	
	@GetMapping("renegociaParcela")
	public Emprestimo RenegociaParcela(RenegociarParcela renegocia) {
		parcelaService.renegociarParcela(renegocia);
		return parcelaService.emprestimo(renegocia.getIdParcela());
	}

	@Override	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id){
		service.remover(id);
	}

}
