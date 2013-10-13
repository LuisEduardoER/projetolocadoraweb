package controller.cmd.manterCliente;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PessoaFisica;

public class CommandSalvarAlteracaoClientePf extends CommandManterClientePfCtrl {
	
	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		PessoaFisica v = new PessoaFisica();
		v.setRegistro(request.getParameter("cpf"));
		v.setNome(request.getParameter("nome"));
		v.setRg(request.getParameter("rg"));

		v.alterar(new PessoaFisica());// IMPLENTAR O ALTERAR CORRETAMENTE**************************************
		
		request.getSession().setAttribute("listaCliente",
				new ArrayList<PessoaFisica>());
		
		return "consulta.jsp";
	}
}
