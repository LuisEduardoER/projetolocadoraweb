package controller.cmd.realizarLocacao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.cmd.Command;

public class CommandImprimirComprovante extends Command{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return "HomePageView.jsp";
	}

}
