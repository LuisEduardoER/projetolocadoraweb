package controller.cmd.manterCliente;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PessoaFisica;

public class CommandExcluirClientePf extends CommandManterClientePfCtrl{
	
	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		PessoaFisica pf = new PessoaFisica();
		pf.setIdPF(Integer.parseInt(request.getParameter("id")));
	
		pf.setNome(request.getParameter("nome"));
	
		pf.setRg(request.getParameter("ra"));

		pf.excluir();
	
		request.getSession().setAttribute("listaCliente",new ArrayList<PessoaFisica>());				
		return "ClientePFConsulta.jsp";
	}
}
