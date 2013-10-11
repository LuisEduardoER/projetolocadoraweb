package controller.cmd.homePage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.cmd.Command;

public class CommandRealizarLocacaoHPCtrl extends Command{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
//		TESTE FORMA PAGAMENTO
		double total = 321;
		request.getSession().setAttribute("totalPedido", total);
		return "FormaPagamento.jsp";
//		=====
	}

}
