package com.emprestimoapi.resource.operacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimoapi.model.entidade.Status;
import com.emprestimoapi.model.operacao.Parcela;
import com.emprestimoapi.model.operacao.resumoConsultas.ResumoParcela;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.filter.ParcelaFilter;
import com.emprestimoapi.repository.filter.RenegociarParcela;
import com.emprestimoapi.repository.operacao.ParcelaRepository;
import com.emprestimoapi.resource.entidade.BaseResource;
import com.emprestimoapi.service.entidade.BaseService;
import com.emprestimoapi.service.operacao.ParcelaService;

@RestController
@RequestMapping("/parcelas")
public class ParcelaResource extends BaseResource<Parcela>{

	private @Autowired ParcelaRepository parcelaRepository;
	private @Autowired ParcelaService service;

	@Override
	public BaseRepository<Parcela, Long> repository() {
		return parcelaRepository;
	}

	@Override
	public BaseService<Parcela> service() {
		return service;
	}
	
	@GetMapping("/status")
	public List<Status> statusUsados(){
		return Parcela.statusUsados();
	}
	
	@GetMapping("pesquisa")
	public List<ResumoParcela> pesquisar(ParcelaFilter filtro) {
		return parcelaRepository.filtrarResumo(filtro);
	}

	
	@GetMapping("recebe")
	public List<ResumoParcela> atualizaStatus(ParcelaFilter filtro) {
		service.atualizarStatus(filtro.getId(), filtro.getIdConta());
		return parcelaRepository.filtrarResumo(filtro);
	}
	
	@GetMapping("renegocia")
	public void RenegociaParcela(RenegociarParcela renegocia) {
		
		service.renegociarParcela(renegocia);
	}
	
	@GetMapping("relatorioParcela")
	public ResponseEntity<byte[]> resumoParcelaRelatorio(ParcelaFilter filtro) throws Exception{
		byte[] relatorio = service.resumoParcelaRelatorio(filtro);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.body(relatorio);
	}
	
}
