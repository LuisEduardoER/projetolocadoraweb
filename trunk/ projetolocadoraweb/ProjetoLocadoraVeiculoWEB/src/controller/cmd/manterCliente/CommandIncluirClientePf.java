package controller.cmd.manterCliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandIncluirClientePf extends CommandManterClientePfCtrl{
	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "ClientePFInclusao.jsp";
	}
}
