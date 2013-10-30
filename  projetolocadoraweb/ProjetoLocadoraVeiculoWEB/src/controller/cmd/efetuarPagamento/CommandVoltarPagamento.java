package controller.cmd.efetuarPagamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.cmd.Command;

public class CommandVoltarPagamento extends Command{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String nextPage = "";
		
		String acao = (String) request.getSession().getAttribute("acaoLocarDevolver");
		if("Locar".equals(acao)){
			nextPage = "LocacaoDados.jsp";
		}else if("Devolver".equals(acao)){
			nextPage = "DevolucaoConsulta.jsp";
		}else{
			nextPage = "HomePageView.jsp";
		}
		
		return nextPage;
	}

}
