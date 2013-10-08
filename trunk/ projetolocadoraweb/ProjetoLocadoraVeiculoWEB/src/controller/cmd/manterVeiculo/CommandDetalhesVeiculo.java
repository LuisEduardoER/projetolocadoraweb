package controller.cmd.manterVeiculo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Veiculo;

public class CommandDetalhesVeiculo extends CommandManterVeiculoCtrl{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		selecionarVeiculo(request , response);
		Veiculo veiculo = (Veiculo) request.getSession().getAttribute("veiculoSelecionado");
		return "VeiculoEdicao.jsp";
	}

}
