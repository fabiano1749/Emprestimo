package com.emprestimoapi.service.operacao;

import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprestimoapi.model.entidade.Status;
import com.emprestimoapi.model.entidade.Usuario;
import com.emprestimoapi.model.operacao.Emprestimo;
import com.emprestimoapi.model.operacao.Parcela;
import com.emprestimoapi.model.operacao.resumoConsultas.ResumoParcelaRelatorio;
import com.emprestimoapi.repository.Entidade.BaseRepository;
import com.emprestimoapi.repository.filter.ParcelaFilter;
import com.emprestimoapi.repository.filter.RenegociarParcela;
import com.emprestimoapi.repository.operacao.ContaRepository;
import com.emprestimoapi.repository.operacao.ParcelaRepository;
import com.emprestimoapi.service.entidade.BaseService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ParcelaService extends BaseService<Parcela>{

	private @Autowired ParcelaRepository parcelaRepository;
	private @Autowired ContaRepository contaRepository;
	
	
	@Override
	public BaseRepository<Parcela, Long> repository() {
		return parcelaRepository;
	}

	public void atualizarStatus(Long id, Long idConta) {
		Usuario usuario = getUsuarioLogado();
		Parcela p = parcelaRepository.findById(id).get();
		
		if(p.getStatus().getNumero() == 1L) {
			p.setStatus(Status.FECHADO);
			if(idConta != null) {
				p.setConta(contaRepository.findById(idConta).get());
			}
			p.setRecebimento(LocalDate.now());
			p.getEmprestimo().calcStatus();
			p.geraLog(usuario);
		}
		else if(p.getStatus().getNumero() == 3L) {
			p.setStatus(Status.ABERTO);
			p.setRecebimento(null);
			p.getEmprestimo().calcStatus();
			p.geraLog(usuario);
		}
		else if(p.getStatus().getNumero() == 8L) {
			p.setStatus(Status.CANCELADO);
			p.setRecebimento(null);
			p.getEmprestimo().calcStatus();
			p.geraLog(usuario);
		}
		parcelaRepository.save(p);
	}
	
	public Emprestimo emprestimo(Long idParcela) {
		Parcela p = parcelaRepository.findById(idParcela).get();
		return p.getEmprestimo();
	}
	
	public void renegociarParcela(RenegociarParcela renegociar) {
		Usuario usuario = getUsuarioLogado();
		renegociar.setConta(contaRepository.findById(renegociar.getIdConta()).get());
		Parcela p = parcelaRepository.getOne(renegociar.getIdParcela());
		p.renegociar(renegociar, usuario);
		p.geraLog(usuario, "Parcela renegociada. Recebida parcialmente.");
		parcelaRepository.save(p);
	}
	
	public byte[] resumoParcelaRelatorio(ParcelaFilter filtro) throws Exception {
		
		List<ResumoParcelaRelatorio> dados = parcelaRepository.filtrarResumoRelatorio(filtro);
		Map<String, Object> parametros = new HashMap<>();
		LocalDate inicio = filtro.dataInicio() == null ? LocalDate.now() : filtro.dataInicio();
		LocalDate fim = filtro.dataFim() == null ? LocalDate.now() : filtro.dataFim();
		parametros.put("DT_INICIO", Date.valueOf(inicio));
		parametros.put("DT_FIM", Date.valueOf(fim));
		parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));
		
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/relatorios/parcelas.jasper");
		
		JasperPrint jaspertPrint = JasperFillManager.fillReport(inputStream, parametros, 
				new JRBeanCollectionDataSource(dados));
				
		return JasperExportManager.exportReportToPdf(jaspertPrint);
		
	}
}
