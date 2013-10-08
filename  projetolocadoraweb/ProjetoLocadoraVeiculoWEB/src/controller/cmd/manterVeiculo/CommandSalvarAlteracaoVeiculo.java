package controller.cmd.manterVeiculo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Veiculo;

public class CommandSalvarAlteracaoVeiculo extends CommandManterVeiculoCtrl{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Veiculo veiculo = (Veiculo) request.getSession().getAttribute("veiculoSelecionado");
		
		carregarObjeto(request , response , veiculo);
						
		//tenta alterar o ve�culo no banco
		try{
//			FactoryDao.obterVeiculoDao().alterar(veiculo);
			veiculo.alterar();
			request.getSession().setAttribute("goToServlet", "manterVeiculo");
			request.getSession().setAttribute("messageTitle", "Mensagem - Altera��o Ve�culo");
			request.getSession().setAttribute("messageBody", "Ve�culo Alterado com sucesso!!!");
								
		}catch(Exception e){
			System.out.println(e.getMessage());
			
			request.getSession().setAttribute("goToServlet", "manterVeiculo");
			request.getSession().setAttribute("messageTitle", "Mensagem - Altera��o Ve�culo");
			request.getSession().setAttribute("messageBody", "N�o foi poss�vel alterar o ve�culo");
		}
		
//		Manda para p�gina de Mensagem
//		request.getRequestDispatcher("Mensagem.jsp").forward(request, response);
		return atualizarConsulta(request, response);
	}

}
