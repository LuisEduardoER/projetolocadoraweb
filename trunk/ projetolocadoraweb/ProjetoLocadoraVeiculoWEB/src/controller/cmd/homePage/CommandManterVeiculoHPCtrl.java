package controller.cmd.homePage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.cmd.Command;

public class CommandManterVeiculoHPCtrl extends Command{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return 	"VeiculoConsulta.jsp";
	}

}
