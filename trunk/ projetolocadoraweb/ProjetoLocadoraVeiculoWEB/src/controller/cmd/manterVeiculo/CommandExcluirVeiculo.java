package controller.cmd.manterVeiculo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Veiculo;

public class CommandExcluirVeiculo extends CommandManterVeiculoCtrl{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Veiculo veiculo = (Veiculo) request.getSession().getAttribute("veiculoSelecionado");
		//tenta excluir o ve�culo no banco
		try{
			veiculo.excluir();
//			FactoryDao.obterVeiculoDao().excluir(veiculo);
			
			request.getSession().setAttribute("goToServlet", "manterVeiculo");
			request.getSession().setAttribute("messageTitle", "Mensagem - Exclus�o Ve�culo");
			request.getSession().setAttribute("messageBody", "Ve�culo Exclu�do com sucesso!!!");
								
		}catch(Exception e){
			System.out.println(e.getMessage());
			
			request.getSession().setAttribute("goToServlet", "manterVeiculo");
			request.getSession().setAttribute("messageTitle", "Mensagem - Exclus�o Ve�culo");
			request.getSession().setAttribute("messageBody", "N�o foi poss�vel excluir o ve�culo");
		}
//		Manda para p�gina de Mensagem
//		request.getRequestDispatcher("Mensagem.jsp").forward(request, response);
		return atualizarConsulta(request, response);
	}
}
