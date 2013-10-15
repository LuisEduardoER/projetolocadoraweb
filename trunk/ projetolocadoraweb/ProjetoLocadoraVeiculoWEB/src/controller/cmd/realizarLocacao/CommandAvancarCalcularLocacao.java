package controller.cmd.realizarLocacao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Locacao;
import model.SerasaImpl;

import controller.cmd.Command;

public class CommandAvancarCalcularLocacao extends Command{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String nextPage = null;
		
//		FUNÇÃO SERASA SERÁ IMPLEMENTADA NA PRÓX. ATIVIDADE
		
//		SerasaImpl serasa = new SerasaImpl();
		Locacao locacao = (Locacao) request.getSession().getAttribute("locacao");
		
//		if(serasa.validar(locacao.getClienteEscolhido()) == true){
////			Mensagem.clientePossuiPendenciasSerasa();
//			System.out.println("Cliente possui pendencias no Serasa");
//			nextPage = "LocacaoDados.jsp";
//		}else{
////			FormaPagamentoCtrl pagamentoCtrl = new FormaPagamentoCtrl(locacao);
////			locacaoCalculaView.dispose();
////			double total = 321;
//			request.getSession().setAttribute("totalPedido", locacao.getTotal());
////			response.sendRedirect("FormaPagamento.jsp");
//			nextPage = "FormaPagamento.jsp";
//		}
		request.getSession().setAttribute("totalPedido", locacao.getTotal());
		request.getSession().setAttribute("acaoLocarDevolver", "Locar");
		nextPage = "FormaPagamento.jsp";
		return nextPage;
	}
	
	
//	class AvancarListener implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			SerasaImpl serasa = new SerasaImpl();
//			if(serasa.validar(locacao.getClienteEscolhido()) == true){
//				Mensagem.clientePossuiPendenciasSerasa();
//			}else{
//				FormaPagamentoCtrl pagamentoCtrl = new FormaPagamentoCtrl(locacao);
//				locacaoCalculaView.dispose();
//			}
//		}
//	}
	
	
	

}
