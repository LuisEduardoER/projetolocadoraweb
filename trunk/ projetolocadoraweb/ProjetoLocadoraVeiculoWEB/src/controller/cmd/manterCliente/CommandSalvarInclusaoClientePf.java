package controller.cmd.manterCliente;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PessoaFisica;

public class CommandSalvarInclusaoClientePf extends CommandManterClientePfCtrl{
	
	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		PessoaFisica pf = new PessoaFisica();
		pf.setNome(request.getParameter("nome"));
		pf.setRg(request.getParameter("rg"));
		pf.incluir(); //OBS: TEM QUE COLOCAR O INCLUIR*******************************************************
		
		request.getSession().setAttribute("listaCliente", new ArrayList<PessoaFisica>());				
		return "consulta.jsp";
	}
}
