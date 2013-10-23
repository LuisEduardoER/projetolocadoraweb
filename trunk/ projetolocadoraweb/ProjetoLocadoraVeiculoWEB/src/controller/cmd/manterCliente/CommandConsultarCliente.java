package controller.cmd.manterCliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.PessoaFisica;

public class CommandConsultarCliente extends CommandManterCliente{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		PessoaFisica pf = new PessoaFisica();
		pf.setRegistro(request.getParameter("txtCnpjCpf"));
		try{
			pf = pf.pesquisar();
			request.getSession().setAttribute("clienteSelecionado",pf);
		}catch (Exception e){
			request.getSession().setAttribute("clienteSelecionado", new Cliente());
		}
		
		return "ClienteConsultar.jsp";
	}
	
	
	
}
