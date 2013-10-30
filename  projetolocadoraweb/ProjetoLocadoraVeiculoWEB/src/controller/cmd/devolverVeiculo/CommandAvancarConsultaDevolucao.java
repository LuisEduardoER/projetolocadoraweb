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
			
			request.getSession().setAttribute("dataAcrescimo", (Double) devolucao.getValoresAdicionais().get(0));
			request.getSession().setAttribute("cidadeAcrescimo", (Double) devolucao.getValoresAdicionais().get(1));
			request.getSession().setAttribute("agenciaAcrescimo", (Double) devolucao.getValoresAdicionais().get(2));
			request.getSession().setAttribute("dataDecrescimo", (Double) devolucao.getValoresAdicionais().get(3));
			request.getSession().setAttribute("subtotalAcrescimo", (Double) devolucao.getValoresAdicionais().get(4));
			request.getSession().setAttribute("subtotalDecrescimo", (Double) devolucao.getValoresAdicionais().get(5));
						
			request.getSession().setAttribute("devolucao", devolucao);
						
			return "DevolucaoValoresAdicionais.jsp";
		}
	}
		

}
