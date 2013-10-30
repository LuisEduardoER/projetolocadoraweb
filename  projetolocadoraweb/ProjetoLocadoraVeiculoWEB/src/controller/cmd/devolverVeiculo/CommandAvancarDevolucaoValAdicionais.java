package controller.cmd.devolverVeiculo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Conversao;

import model.Devolucao;

import controller.cmd.Command;

public class CommandAvancarDevolucaoValAdicionais extends Command{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Devolucao devolucao = (Devolucao) request.getSession().getAttribute("devolucao");
		String nextPage = "";
		if(devolucao.getTotal() < 0.0){
			String valor = Conversao.formatDouble( (-1 * devolucao.getTotal()) );
			System.out.println("Troco: " + valor);
			devolucao.setTotal( devolucao.getTotal() + devolucao.getLocacao().getTotal() );
//			Criar uma Devolução no Banco
			devolucao.inserir();
			devolucao.setId(devolucao.obterUltimoRegistro());
			request.getSession().setAttribute("devolucao", devolucao);
			nextPage = "DevolucaoComprovante.jsp";
		}
		else{
			if(devolucao.getTotal() == 0.0){
				devolucao.setTotal(devolucao.getTotal() + devolucao.getLocacao().getTotal());
//				request.getSession().setAttribute("devolucao", devolucao);
//				Criar uma Devolução no Banco
				devolucao.inserir();
				devolucao.setId(devolucao.obterUltimoRegistro());
				request.getSession().setAttribute("devolucao", devolucao);
				nextPage = "DevolucaoComprovante.jsp";
			}
			else{
				request.getSession().setAttribute("totalPedido", devolucao.getTotal());
				request.getSession().setAttribute("acaoLocarDevolver", "Devolver");
				nextPage = "FormaPagamento.jsp";
			}
		}
				
		return nextPage;
	}

}
