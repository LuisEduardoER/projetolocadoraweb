package controller.cmd.manterVeiculo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agencia;
import model.Veiculo;

public class CommandSalvarInclusao extends CommandManterVeiculoCtrl {

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Veiculo veiculo = new Veiculo();
		carregarObjeto(request , response , veiculo);
		
		Agencia ag = (Agencia) request.getSession().getAttribute("agenciaSelecionada");
		
		//tenta inserir o ve�culo no banco
		try{
			veiculo.inserir(ag.getCodigo());
			
			request.getSession().setAttribute("goToServlet", "manterVeiculo");
			request.getSession().setAttribute("messageTitle", "Mensagem - Inclus�o Ve�culo");
			request.getSession().setAttribute("messageBody", "Ve�culo Incluido com sucesso!!!");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			
			request.getSession().setAttribute("goToServlet", "manterVeiculo");
			request.getSession().setAttribute("messageTitle", "Mensagem - Inclus�o Ve�culo");
			request.getSession().setAttribute("messageBody", "N�o foi poss�vel incluir o ve�culo");						
		
		}
//		Manda para p�gina de Mensagem
//		request.getRequestDispatcher("Mensagem.jsp").forward(request, response);
		
		return atualizarConsulta(request, response);
	}
	
}
