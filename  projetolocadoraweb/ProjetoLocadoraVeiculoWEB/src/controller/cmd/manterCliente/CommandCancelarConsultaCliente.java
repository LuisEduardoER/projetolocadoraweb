package controller.cmd.manterCliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandCancelarConsultaCliente extends CommandManterCliente {

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return "HomePageView.jsp";
	}

}
