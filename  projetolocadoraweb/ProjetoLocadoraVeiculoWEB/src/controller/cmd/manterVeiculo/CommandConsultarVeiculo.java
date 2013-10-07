package controller.cmd.manterVeiculo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandConsultarVeiculo extends CommandManterVeiculoCtrl{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return atualizarConsulta(request, response);
				
	}
	
}
