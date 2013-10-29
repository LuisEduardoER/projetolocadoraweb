package controller.cmd.devolverVeiculo;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agencia;
import model.Devolucao;
import model.Locacao;

import controller.cmd.Command;

public class CommandAvancarConsultaDevolucao extends Command {

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Locacao locacao = (Locacao) request.getSession().getAttribute("locacao");
		if(locacao == null){
			return "DevolucaoConsulta.jsp";
		}else{
			
			Devolucao devolucao = new Devolucao();
			devolucao.setAgenciaDevolucao((Agencia)request.getSession().getAttribute("agenciaSelecionada"));
			devolucao.setDtaDevolucao(new Date());
			devolucao.setLocacao(locacao);
			devolucao.calcularValAdicionais();
			
//			request.getSession().setAttribute("dataAcrescimo", (double) devolucao.getValoresAdicionais().get(0));
//			request.getSession().setAttribute("cidadeAcrescimo", (double) devolucao.getValoresAdicionais().get(1));
//			request.getSession().setAttribute("agenciaAcrescimo", (double) devolucao.getValoresAdicionais().get(2));
//			request.getSession().setAttribute("dataDecrescimo", (double) devolucao.getValoresAdicionais().get(3));
//			request.getSession().setAttribute("subtotalAcrescimo", (double) devolucao.getValoresAdicionais().get(4));
//			request.getSession().setAttribute("subtotalDecrescimo", (double) devolucao.getValoresAdicionais().get(5));
			
			
			request.getSession().setAttribute("devolucao", devolucao);
			
//			devolucao = new Devolucao();
//			devolucao.setAgenciaDevolucao(agencia);
//			devolucao.setDtaDevolucao(new Date());
//			devolucao.setLocacao(locacao);
//			calcularView = new DevolucaoValAdicionaisView();
//			adicionarListener();
//			carregarCamposSuperior();
//			calcularValAdicionais();
			
			
			return "DevolucaoValoresAdicionais.jsp";
		}
	}
		

}
