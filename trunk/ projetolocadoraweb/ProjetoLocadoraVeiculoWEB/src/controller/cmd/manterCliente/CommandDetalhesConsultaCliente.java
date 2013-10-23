package controller.cmd.manterCliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PessoaFisica;

public class CommandDetalhesConsultaCliente extends CommandManterCliente{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		PessoaFisica pf = (PessoaFisica) request.getSession().getAttribute("clienteSelecionado");
		
		if(pf == null){
			return "ClienteConsultar.jsp";
		}else{
			return "ClienteEdicaoPF.jsp";
		}
		
	}

}
