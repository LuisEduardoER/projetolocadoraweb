package controller.cmd.manterCliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;

import controller.cmd.Command;

public class CommandEscolherCliente extends Command{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String opcao = request.getParameter("escolherCliente");
		
		System.out.println(opcao);
		
		if("pf".equals(opcao)){
			request.getSession().getAttribute("clienteSelecionado");
			request.getSession().setAttribute("clienteSelecionado", new Cliente());
		}else if("pj".equals(opcao)){
			
		}
		return "ClienteConsultar.jsp";
		
	}

}
