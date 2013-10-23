package controller.cmd.homePage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.cmd.Command;

public class CommandCadastrarClienteHPCtrl extends Command{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "ClienteCadastrarPF.jsp";
	}

}
