package controller.cmd.manterCliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandDetalharClientePf extends CommandManterClientePfCtrl {
	
	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		selecionarCliente(request, response);

		request.getSession().setAttribute("operacao", "detalhar");
		request.getSession().setAttribute("idCliente",
				new Long(request.getParameter("item")));
		
		return "detalhe.jsp";
	}

}
