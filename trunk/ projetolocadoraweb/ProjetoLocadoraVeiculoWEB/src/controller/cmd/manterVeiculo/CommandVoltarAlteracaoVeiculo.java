package controller.cmd.manterVeiculo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandVoltarAlteracaoVeiculo extends CommandManterVeiculoCtrl{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "VeiculoEdicao.jsp";
	}

}
