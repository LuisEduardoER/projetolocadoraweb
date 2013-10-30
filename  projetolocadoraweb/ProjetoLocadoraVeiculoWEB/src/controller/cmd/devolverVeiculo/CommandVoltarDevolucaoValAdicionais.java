package controller.cmd.devolverVeiculo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.cmd.Command;

public class CommandVoltarDevolucaoValAdicionais extends Command{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return "DevolucaoConsulta.jsp";
	}

}
