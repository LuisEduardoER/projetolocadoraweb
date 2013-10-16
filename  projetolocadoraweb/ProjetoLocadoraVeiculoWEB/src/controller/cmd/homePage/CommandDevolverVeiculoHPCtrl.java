package controller.cmd.homePage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Locacao;

import controller.cmd.Command;

public class CommandDevolverVeiculoHPCtrl extends Command {

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
//		Inicializa com uma locação vazia
		request.getSession().setAttribute("locacao", new Locacao());
		
		return "DevolucaoConsulta.jsp";
	}

}
