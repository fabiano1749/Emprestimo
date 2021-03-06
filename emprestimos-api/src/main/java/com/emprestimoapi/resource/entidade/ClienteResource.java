package com.emprestimoapi.resource.entidade;


import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimoapi.event.RecursoCriadoEvent;
import com.emprestimoapi.model.entidade.Cliente;
import com.emprestimoapi.model.entidade.Endereco;
import com.emprestimoapi.model.entidade.EnderecoContatoCliente;
import com.emprestimoapi.model.entidade.Status;
import com.emprestimoapi.model.entidade.resumoConsultas.ResumoCliente;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.Entidade.ClienteRepository;
import com.emprestimoapi.repository.filter.ClienteFilter;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.entidade.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource extends BaseResource<Cliente>{

	private @Autowired ClienteRepository clienteRepository;
	private @Autowired ClienteService service;
	
	@PostMapping
	public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente entidade, HttpServletResponse response){
		Cliente entidadeSalva = service.salvar(entidade);
		getPublisher().publishEvent(new RecursoCriadoEvent(this, response, entidadeSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(entidadeSalva);
	}
	
	@Override
	public BaseRepository<Cliente, Long> repository() {
		return clienteRepository;
	}

	@Override
	public BaseService<Cliente> service() {
		return service;
	}
	
	@GetMapping("/status")
	public List<Status> statusUsados(){
		return Cliente.statusUsados();
	}
	
	@GetMapping("pesquisa")
	public List<ResumoCliente> pesquisar(ClienteFilter filtro) {
		return clienteRepository.resumoCliente(filtro);
	}
	
	@GetMapping("pesquisaOrdenada")
	public List<Cliente> entidades() {
		List<Cliente> clientes = clienteRepository.findAll();
		clientes.sort( (a, b) -> a.getNome().toLowerCase().compareTo(b.getNome().toLowerCase()) );
		return clientes;
	}
	
	@GetMapping("/enderecosCliente/{id}")
	public List<Endereco> enderecosByIdCliente(@PathVariable("id") Long idCliente){
		return clienteRepository.findById(idCliente).get().getEnderecos();
	}
	
	@GetMapping("/dadosCliente/{id}")
	public EnderecoContatoCliente dadosCliente(@PathVariable("id") Long idCliente){
		return clienteRepository.findById(idCliente).get().enderecoContato();
	}
}
