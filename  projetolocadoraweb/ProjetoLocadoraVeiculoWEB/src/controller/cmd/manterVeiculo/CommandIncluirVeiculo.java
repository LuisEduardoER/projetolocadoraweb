package controller.cmd.manterVeiculo;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Grupo;
import model.Veiculo;

public class CommandIncluirVeiculo extends CommandManterVeiculoCtrl {

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		Veiculo veiculo = new Veiculo();
		grupos = veiculo.getListGrupo();
		request.getSession().setAttribute("listaGrupos",grupos);
		return "VeiculoIncluir.jsp";
	}

}
